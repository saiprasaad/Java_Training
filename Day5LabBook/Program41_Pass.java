package Day5LabBook;
public class Program41_Pass{
static int j=20; // since j is static j value is 40 at the end
public static void main(String argv[]){
int i=10;
Program41_Pass p = new Program41_Pass();
p.amethod(i);
System.out.println(i); // prints 10
System.out.println(j);  // prints 40
}
public void amethod(int x){
x=x*2;
j=j*2;
}
}