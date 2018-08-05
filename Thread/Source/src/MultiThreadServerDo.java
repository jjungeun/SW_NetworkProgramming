package ThreadServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.*;

public class MultiThreadServerDo {
	public static void main(String args[]) {

		if (args.length != 1) {
			System.out.println("Usage: Classname ServerPort");
			System.exit(1);
		}
		
		int serverPort = Integer.parseInt(args[0]);
		
		MultiThreadServer server = new MultiThreadServer(serverPort);
		new Thread(server).start();
		
		try {
			Thread.sleep(30 * 1000); // 1000 (1sec)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		server.stop();
	}
}

class MultiThreadServer implements Runnable {

	protected int          serverPort   = 0000;
	protected ServerSocket serverSocket = null;
	protected boolean      isStopped    = false;
	protected Thread       runningThread= null;
	   
	public MultiThreadServer(int port){
		this.serverPort = port;
	}

	public void run() {
		synchronized(this) {
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		
		while(! isStopped()) { // multiThread
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();				
				System.out.println("Client connection accepted");
			} catch (IOException e) {
				if(isStopped()) {
					return;
				}
				throw new RuntimeException(
						"Error accepting client connection", e);
			}
			
			new Thread(
			new MultiRunnable(clientSocket, "Multithreaded Server")
			).start();
			System.out.println("use Thread");
		}
	}
	
	private synchronized boolean isStopped() {
		return this.isStopped;
	}

	public synchronized void stop(){
		this.isStopped = true;
		try {
			this.serverSocket.close();
			System.out.println("Close serverSocket");
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}

	private void openServerSocket() {
		...
	}
}

class MultiRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public MultiRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        ...
    }
}