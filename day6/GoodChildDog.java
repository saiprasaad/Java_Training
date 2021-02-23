package day6;

import java.util.Scanner;

public class GoodChildDog {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	String obj="";
	obj="day6."+scan.next();
	try
	{
	while(!(obj.equals("day6.-1")))
	{
	Item item=(Item)Class.forName(obj).newInstance();
	item.doAction();
	obj="day6."+scan.next();
	}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
abstract class Item
{
	abstract void doAction();
}
class Stone extends Item
{
	@Override
	void doAction() {
		System.out.println("you hit I bark.....");
	}
}

class Stick extends Item
{
	@Override
	void doAction() {
		System.out.println("you beat I bite......");
		
	}
}