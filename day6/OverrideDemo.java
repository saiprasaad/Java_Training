package day6;

public class OverrideDemo {
	public static void main(String[] args) {
	Parent parent=new Child();
	parent.met();
	}	
}
//base class
abstract class Parent
{
	final float pi=3.14f; // its value cannot be changed
	public void met() {
		System.out.println("parent method called");
	}
}
// subclass
class Child extends Parent
{
	public void met() {
		System.out.println("child method called");
	}
}
