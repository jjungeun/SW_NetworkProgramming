import java.io.*;

public class OutputStreamDo {
	public static void main(String[] args) {
		
		OutputStream out = System.out;
		
		char out1 = 'A';
		char out2 = '1';
		
		try {
			out.write(out1);
			out.write(out2);
			
			out.flush();
			out.close();
		}
		catch(IOException ie) {
			System.out.println("¿¹¿Ü´Â"+ie);
		}
	}
}