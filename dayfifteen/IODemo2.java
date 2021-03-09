package dayfifteen;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo2 {
	public static void main(String[] args) {
		File file =new File("C:\\html");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.exists());
		System.out.println(file.canWrite());
		System.out.println(file.isDirectory());
		String s[]=file.list(new MyFilter("html"));
		for(String sobj:s) {
			System.out.println(sobj);
		}
	}
}
class MyFilter implements FilenameFilter 
{
	String extension="";
	public MyFilter(String extension) {
		this.extension=extension;
	}
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith("."+extension);
	}
	
}
