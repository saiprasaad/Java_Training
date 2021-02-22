package Day5LabBook;

class Base {}
class Sub extends Base {}
class Sub2 extends Base {}
public class Program17_CEx{
public static void main(String argv[]){
Base b=new Base();
Sub s=(Sub) b; //  class day5.Base cannot be cast to class day5.Sub
}
}