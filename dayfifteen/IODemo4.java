package dayfifteen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class IODemo4 {
	public static void main(String[] args) throws IOException {
		String s="sai hello";
		PushbackInputStream pbs=new PushbackInputStream(new ByteArrayInputStream(s.getBytes()));
		int c=0;
		while((c=pbs.read())!=-1) {
			if((char)c=='s') {
				pbs.unread('H');
			}
			else
			{
				System.out.println((char)c);
			}
		}
	}
}
