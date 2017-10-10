import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

public class DrivingTest {
	private int driveNum;
	// This test uses a mock class and stubs to test the begin method
	@Test
	public void testStart() {
		Random rand = new Random(10);
		MockDriving mock = new MockDriving(new Driver(0), 0, rand);

		assertTrue(mock.begin());
	}

	//This test ensures that all coordinates go to it respective area
	@Test
	public void testCoordinates() {
		Random rand = new Random(10);
		Driving driving = new Driving(new Driver(0), 0, rand);

		assertEquals(driving.getNew(2, 1), 0);
		assertEquals(driving.getNew(4, 0), 0);
		assertEquals(driving.getNew(0, 0), 1);
		assertEquals(driving.getNew(3, 1), 1);
		assertEquals(driving.getNew(0, 1), 2);
		assertEquals(driving.getNew(3, 0), 2);
		assertEquals(driving.getNew(1, 1), 3);
		assertEquals(driving.getNew(4, 1), 3);
		assertEquals(driving.getNew(1, 0), 4);
		assertEquals(driving.getNew(2, 0), 4);
	}

	// This test ensures that all areas in the city have valid names
	@Test
	public void testAreas() {
		Random rand = new Random(10);
		Driving driving = new Driving(new Driver(0), 0, rand);

		assertTrue("Hotel".equals(driving.getAreaName(0))); //Double
		assertTrue("Diner".equals(driving.getAreaName(1))); // Double
		assertTrue("Library".equals(driving.getAreaName(2))); //Double
		assertTrue("Coffee".equals(driving.getAreaName(3))); //Double
		assertTrue("Outside City".equals(driving.getAreaName(4))); //Double
	}

	//This test ensures that it fails if a city isn't recognized
	// THIS TEST SHOULD PASS because of AssertFalse
	@Test
	public void testInvalidArea() {
		Random rand = new Random(10);
		Driving driving = new Driving(new Driver(0), 0, rand);

		assertFalse("InvalidArea".equals(driving.getAreaName(5)));
	}

	// This test ensures that all city names are correct
	@Test
	public void testStreets() {
		Random rand = new Random(10);
		Driving driving = new Driving(new Driver(0), 0, rand);

		assertTrue(driving.getStreet(0, 1).equals("Fourth Ave."));
		assertTrue(driving.getStreet(1, 4).equals("Fourth Ave.\nDriver " + driveNum + " has gone to Philadelphia!"));
		assertTrue(driving.getStreet(4, 0).equals("Fourth Ave."));
		assertTrue(driving.getStreet(2, 4).equals("Fifth Ave.\nDriver " + driveNum + " has gone to Cleveland!"));
		assertTrue(driving.getStreet(3, 2).equals("Fifth Ave."));
		assertTrue(driving.getStreet(4, 3).equals("Fifth Ave."));
		assertTrue(driving.getStreet(0, 2).equals("Bill St."));
		assertTrue(driving.getStreet(2, 0).equals("Bill St."));
		assertTrue(driving.getStreet(1, 3).equals("Phil St."));
		assertTrue(driving.getStreet(3, 1).equals("Phil St."));
	}

	// This test ensures that it fails if a street isn't recognized
	// THIS TEST SHOULD PASS because assertFalse
	@Test
	public void testInvalidStreet() {
		Random rand = new Random(10);
		Driving driving = new Driving(new Driver(0), 0, rand);

		assertFalse(driving.getStreet(5, 5).equals("Invalid St."));
	}
}
