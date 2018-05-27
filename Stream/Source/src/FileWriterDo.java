import java.io.*;

public class FileWriterDo
{
	public static void main(String[] args)
	{
		String what1 = new String("안녕하신가요? ㅡ.ㅡ\r\n");
		String what2 = new String("자바 네트워크 프로그래밍을 듣고 있습니다.신정은입니다");

		try
		{
			FileWriter fw = new FileWriter("./bin/data/base.txt",true);
			fw.write(what1);
			fw.write(what2);
			fw.close();
		}
		catch(IOException ie) {
			System.out.println("예외는"+ie);
		}
	}
}