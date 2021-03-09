package dayfifteen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class IODemo1 {
	public static void main(String[] args) {
		new CopyCommand().copy("C:\\Java\\java_training\\eycorejava\\src\\dayfifteen\\sample.properties");
	
	}
}

class CopyCommand
{
	public void copy(String filename)
	{
		FileInputStream fis=null; 
		FileOutputStream fos=null;
		FileReader read=null;
		try(FileWriter filewriter=new FileWriter("C:\\\\Java\\\\java_training\\\\eycorejava\\\\src\\\\dayfifteen\\\\copy.properties"))
		{
			read=new FileReader(filename);
			int nocharsread;
			char c[]=new char[8];
			while((nocharsread=read.read(c))!=-1)
			{
				String s=new String(c,0,nocharsread);
				System.out.println(s);
				System.out.println("loop runs....");
				filewriter.write(c,0,nocharsread);
			}
			
		}
		catch(Exception e) {e.printStackTrace();}
	}
}
