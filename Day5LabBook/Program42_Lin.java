package Day5LabBook;

public class Program42_Lin{
public static void main(String argv[]){
Program42_Lin l = new Program42_Lin();
l.amethod();
}
public void amethod(){
int ia[] = new int[4];
for(int i=0; i< ia.length;i++) // iterates from i value 0 to 4
{
ia[i]=i;
System.out.println(ia[i]);
}
}
}