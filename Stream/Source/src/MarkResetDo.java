import java.io.*;

public class MarkResetDo {
	public static void main(String[] args) throws Exception {
      
		InputStream is = null;
		BufferedInputStream bis = null;
      
		try
		{       
			is = new FileInputStream("./bin/data/base.txt");
			bis = new BufferedInputStream(is);
			
			System.out.println("Char : "+(char)bis.read());
			System.out.println("Char : "+(char)bis.read());
			
			System.out.println("mark() invoked");
			bis.mark(0);
			
			System.out.println("Char : "+(char)bis.read());
			System.out.println("char : "+(char)bis.read());
			
			System.out.println("reset() invoked");
			bis.reset();
			
			System.out.println("char : "+(char)bis.read());
			System.out.println("char : "+(char)bis.read());
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(is != null) is.close();
			if(bis != null) bis.close();
		}
	}
}