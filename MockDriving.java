import java.util.*;

// This is used to test the begin of the mock version of Driving
public class MockDriving {
	private int driveNum;
	private Driver driver;

	//Default
	public MockDriving(Driver driver, int driveNum, Random rand) {
		this.driver = driver;
		this.driveNum = driveNum;
	}

	public boolean begin() {
		int startArea = 0;
		do {
			startArea = driver.getArea();
			newArea();
			printArea(startArea, driver.getArea());
		} while (driver.getArea() != 4);
		return true;
	}

	public void newArea() {driver.setArea(4);}

	public String getAreaName(int num) {return "Outside City";}

	public int getNew(int startArea, int newArea) {return 4;}

	public String getStreet(int startArea, int newArea) {return "via Fifth Ave.";}

	public void printArea(int startArea, int newArea) {
		System.out.println("Driver " + driveNum + " heading from " + getAreaName(startArea) + " to " +
							getAreaName(newArea) + getStreet(startArea, newArea));
	}
}
