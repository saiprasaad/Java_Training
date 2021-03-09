package dayfourteen;
import java.util.Observable;
import java.util.Observer;
public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm alarm=new FireAlarm();
		Student sai=new Student();
		Teacher shoaib=new Teacher();
		alarm.addObserver(sai);
		alarm.addObserver(shoaib);
		alarm.setAlarm();
	}
}
class FireAlarm extends Observable
{
	public void setAlarm() {
	setChanged();
	notifyObservers();
	}
}

class Student implements Observer
{
	@Override
	public void update(Observable o, Object arg) {
		run();
	}
	public void run()
	{
		System.out.println("The Student is running");
	}
}

class Teacher implements Observer
{
	@Override
	public void update(Observable o, Object arg) {
		run();
	}
	public void run()
	{
		System.out.println("The Teacher is running");
	}
}