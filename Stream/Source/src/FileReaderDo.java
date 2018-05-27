import java.io.*;

public class FileReaderDo
{
	public static void main(String[] args)
	{
		try
		{
			FileReader fr = new FileReader("./bin/data/base.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String s;
			while((s=br.readLine())!=null) {
				System.out.println(s);
			}
			fr.close();
		}
		catch(IOException ie)
		{
			System.out.println("예외냐? 이것때문: " + ie);
		}
	}
}