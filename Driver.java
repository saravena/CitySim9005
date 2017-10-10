
public class Driver {
	private int currArea;
	
	// Default
	public Driver(int currArea) {
		this.currArea = currArea;
	}
	
	// Get the current area
	public int getArea() {
		return currArea;
	}
	
	//Set the current area
	public int setArea(int newArea) {
		currArea = newArea;
		return currArea;
	}
}
