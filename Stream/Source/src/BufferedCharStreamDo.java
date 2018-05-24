import java.io.*;

public class BufferedCharStreamDo
{
	public static void main(String[] argv)
	{
		int i, len = 0;

		String sourFile = "./bin/data/base.txt";
		String destFile = "./bin/data/output_char.txt";

		System.out.println("Source Name:"+sourFile);
		System.out.println("Target Name:"+destFile);
		
	    try
	    {
	    	BufferedReader br = null;
	    	BufferedWriter bw = null;
	    	
	    	br = new BufferedReader(new FileReader(sourFile));
	    	bw = new BufferedWriter(new FileWriter(destFile));
	    	
	    	while((i=br.read())!=-1) 
	    	{
	    	    bw.write(i);
	    	    
	    	    len+=1;
	    	    System.out.println("Read data["+i+","+len+"]");
	    	}
	    	br.close();
	    	bw.close();
	    	System.out.println("finished");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
