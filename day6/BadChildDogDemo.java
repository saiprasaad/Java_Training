package day6;
import java.util.Scanner;
public class BadChildDogDemo {
	public static void main(String[] args) {
		BullDog tiger=new BullDog();
		NaughtyChild baby=new NaughtyChild();
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter a item...:");
		String item=scan.next();
		baby.playWithDog(tiger, item);
	}
}
class BullDog{
	public void play(String item) {
		if(item.equals("stick")) {
			System.out.println("you beat I bite......");
		}
		else if(item.equals("stone")) {
			System.out.println("you hit I bark.....");
		}
	}
}
class NaughtyChild{
	public void playWithDog(BullDog dog,String item) {
		dog.play(item);
	}
}