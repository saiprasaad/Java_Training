package day3;

public class StaticDemo {
	public static void main(String[] args) {
		Connection con=Connection.getConnection();
		Connection.somemethod();
	}
}

class Connection{
	private Connection() {
		System.out.println("Constructor of Connection called");
	}
	static {
		System.out.println("static block called");
	}
	public static Connection getConnection() {
		return new Connection();
	}
	public static void somemethod() {
		
	}
}