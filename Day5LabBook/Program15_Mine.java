package Day5LabBook;

import java.io.*;
public class Program15_Mine {
public static void main(String argv[]){
Program15_Mine m=new Program15_Mine();
System.out.println(m.amethod()); // -1 is printed atlast
}
public int amethod() {
try {
FileInputStream dis=new FileInputStream("Hello.txt");
}catch (FileNotFoundException fne) {
System.out.println("No such file found"); // exception is caught as no file is found
return -1;
}catch(IOException ioe) {
} finally{
System.out.println("Doing finally"); // finally block is executed always
}
return 0;
}
}