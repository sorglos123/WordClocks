package cs18_1_clock;

public class Launcher {

	public static void main(String[] args) {
		View v = new View();
		Controller c = new Controller();
		c.initialise(v);
		v.initialise(c);
		
		
		
	}

}
