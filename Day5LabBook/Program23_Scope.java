package Day5LabBook;

class BaseClass{
public void amethod(int i) { }
}
public class Program23_Scope extends BaseClass{
public static void main(String argv[]){
}
//public void amethod(int i) throws Exception {}  must not be defined with throw exception
//public void amethod(long i) throws Exception {} must not be defined with throw exception
void amethod(long i){}
//public void amethod(int i) throws Exception {} must not be defined with throw exception
}
