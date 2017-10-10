import static org.junit.Assert.*;
import org.junit.Test;

public class DriverTest {
	// That ensures that getting area of the driver functions correctly
	@Test
	public void testGetArea() {
		Driver driver = new Driver(0); //Double
		assertEquals(0, driver.getArea());
	}

	// Test that ensures setting the current area of the driver functions correctly
	@Test
	public void testSetArea() {
		Driver driver = new Driver(0); // Double
		driver.setArea(3);
		assertEquals(3, driver.getArea());
	}
}
