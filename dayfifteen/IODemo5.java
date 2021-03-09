package dayfifteen;

import java.io.ByteArrayInputStream;
import java.io.StringBufferInputStream;

public class IODemo5 {
	public static void main(String[] args) {
		ByteArrayInputStream bis=new ByteArrayInputStream("helloworld".getBytes());
		StringBufferInputStream sbis=new StringBufferInputStream("hello hai world");
		
	}
}
