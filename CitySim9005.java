import java.util.*;

public class CitySim9005 {

	public static void main(String[] args) {
		
		int seed = 0;
		
		// check for valid arguments
		if (args.length == 0 || args.length > 1) {
			System.out.println("Invalid number of integer arguments.");
			System.exit(1);
		} else {
			try {
				seed = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Argument is not an integer.");
				System.exit(1);
			}
		}
		
		// start driving through city
		Random randSeed = new Random(seed);
		for (int i = 1; i < 6; i++) {
			Driving driving = new Driving(new Driver(randSeed.nextInt(5)), i, randSeed);
			driving.start();
		}
	}
}
