import java.util.*;

public class Driving {
	// Private Vars
	private Driver driver;
	private int driveNum;
	private Random rand;
	
	// Default
	public Driving(Driver driver, int driveNum, Random rand) {
		this.driver = driver;
		this.driveNum = driveNum;
		this.rand = rand;
	}
	
	// Begin driving through city until you leave
	public void begin() {
		int startArea = 0;
		
		do {
			startArea = driver.getArea();
			newArea(startArea);
			printArea(startArea, driver.getArea());
		} while(driver.getArea() != 4);	
		System.out.println("\n-------------------\n");
	}
	
	// Change to new area
	public void newArea(int startArea) {
		int newArea = getNew(startArea, rand.nextInt(2));
		driver.setArea(newArea);
	}
	
	// Gets the current name of the area
	public String getAreaName(int currArea) {
		String area;
		switch(currArea) {
		case 0:  area = "Hotel";
				 break;
		case 1:  area = "Diner";
				 break;
		case 2:  area = "Library";
				 break;
		case 3:  area = "Coffee";
				 break;
		default: area = "Outside City";
				 break;
		}
		return area;
	}
	
	// Gets the new area
	public int getNew(int startArea, int newArea) {
		if (startArea == 0 && newArea == 0) {return 1;}
		else if (startArea == 3 && newArea == 1) {return 1;}
		else if (startArea == 0 && newArea == 1) {return 2;}
		else if (startArea == 3 && newArea == 0) {return 2;}
		else if (startArea == 1 && newArea == 1) {return 3;}
		else if (startArea == 1 && newArea == 0) {return 4;}
		else if (startArea == 2 && newArea == 0) {return 4;}
		else if (startArea == 2 && newArea == 1) {return 0;}
		else if (startArea == 4 && newArea == 0) {return 0;}
		else {return 3;}
	}
	
	// Gets the current street
	public String getStreet(int startArea, int newArea) {
		if (startArea == 0 && newArea == 1) {return "Fourth Ave.";}
		else if (startArea == 1 && newArea == 4) {return ("Fourth Ave.\nDriver " + driveNum + " has gone to Philadelphia!");}
		else if (startArea == 4 && newArea == 0) {return "Fourth Ave.";}
		else if (startArea == 0 && newArea == 2) {return "Bill St.";}
		else if (startArea == 2 && newArea == 0) {return "Bill St.";}
		else if (startArea == 1 && newArea == 3) {return "Phil St.";}
		else if (startArea == 3 && newArea == 1) {return "Phil St.";}
		else if (startArea == 2 && newArea == 4) {return ("Fifth Ave.\nDriver " + driveNum + " has gone to Cleveland!");}
		else if (startArea == 3 && newArea == 2) {return "Fifth Ave.";}
		else {return "Fifth Ave.";}
	}
	
	// Prints the drivers current movement
	public void printArea(int startArea, int newArea) {
		System.out.println("Driver " + driveNum + " heading from " + getAreaName(startArea) + " to " + getAreaName(newArea) +
							" via " + getStreet(startArea, newArea));
	}
}
