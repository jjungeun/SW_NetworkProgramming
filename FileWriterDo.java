import java.io.*;

public class FileWriterDo
{
	public static void main(String[] args)
	{
		String what1 = new String("�ȳ��ϽŰ���? ��.��\r\n");
		String what2 = new String("�ڹ� ��Ʈ��ũ ���α׷����� ��� �ֽ��ϴ�.�������Դϴ�");

		try
		{
			FileWriter fw = new FileWriter("./bin/data/base.txt",true);
			fw.write(what1);
			fw.write(what2);
			fw.close();
		}
		catch(IOException ie) {
			System.out.println("���ܴ�"+ie);
		}
	}
}