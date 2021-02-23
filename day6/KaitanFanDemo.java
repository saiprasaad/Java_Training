package day6;

import java.util.Scanner;

public class KaitanFanDemo {

	public static void main(String[] args) throws Exception{
		Fan fan=FanContainer.adjustSpeed("day6.Speed1");
		fan.run();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			scanner.nextInt();
			fan=FanContainer.adjustSpeed(fan.speed.next);
			fan.run();
		}

	}
}

abstract class Speed{
	String next="day6.Speed1";
	
}

class Speed1 extends Speed{
	
	public Speed1() {
		next="day6.Speed2";
	}
	
	@Override
	public String toString() {
		return "Fan Running in Speed 1";
	}
	
}

class Speed2 extends Speed{
	
	public Speed2() {
		next="day6.Speed3";
	}
	
	@Override
	public String toString() {
		
		return "Fan Running in Speed 2";
	}
	
}

class Speed3 extends Speed{
	
	public Speed3() {
		next="day6.Speed1";
	}
	
	public String toString() {

		return "Fan Running in Speed 3";
	}
	
}

class Fan{
	Speed speed;
	public void run() {
		System.out.println(speed.toString());
		
	}
	
}


class FanContainer{
	public static Fan adjustSpeed(String classname) throws Exception {
		Fan fan=new Fan();
		Speed speed=(Speed)Class.forName(classname).newInstance();
		fan.speed=speed;
		return fan;
	}
}