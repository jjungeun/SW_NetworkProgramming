import java.io.*;

public class InputStreamDo {
	public static void main(String[] args) {
		InputStream in = System.in;

		try
		{
			while(true) {
				int i = in.read();
				if(i ==-1)
					break;
				char c=(char)i;
				System.out.print(c);
			}
		}
		catch(IOException ie) {
			System.out.println("¿¹¿Ü´Â"+ie);
		}
	}
}