package lab1;

public class Program25_Base {
	public static void main(String[] args) {
		
	}
}
protected class Base{ //modifier protected not allowed here
	String method() {
		return "wow";
	}
}

class Derived{  
	public void useD() {
		Base zBase=new Base();
		System.out.println("base says "+zBase.method());
		
	}
}
