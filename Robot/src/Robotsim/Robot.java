package Robotsim;


public class Robot {

	
	private int x,y, robotid, dx, dy;
	private static int Robotcout = 0; // Static variable to keep count of Robot instances
	private Direction direction; // Enum to manage direction state
	
	
	// Constructor for creating a new Robot instance
	public Robot (int rx , int ry,  Direction direction) {
		x = rx; // Set  X coordinate
		y = ry; // Set  Y coordinate
		
		robotid = Robotcout++; // Assign a unique ID to the robot and increment the count
		// Set the default movement increment
		dx = 1; 
		dy = 1; 
		
		this.direction = direction; // Set the initial direction of the robot
		
	}
	
	
	/**
	 * Display the Robot in the given canvas
	 * @param c the canvas used for displaying the robot
	 */
	public void displayRobot(ConsoleCanvas c) {
		
		   int x = getX(); // gets robots x direction
		   int y = getY(); // gets robots y direction
		
		// Display the robot at its current position on the canvas
		c.showIt(x, y , 'R');
		
		}
	
	
	/**
	 * Attempt to move the robot in its current direction within the arena
	 * @param arena the robot arena where movement is checked
	 */
	
	public void tryToMov(RobotArena arena) {
		
		// Initialise next position based on current position
	    int nextX = x;
	    int nextY = y;

	 // Calculate next position based on current direction
	    if (direction == Direction.NORTH) {
	        nextY = y - 1;
	    } else if (direction == Direction.WEST) {
	        nextX = x - 1;
	    } else if (direction == Direction.EAST) {
	        nextX = x + 1;
	    } else if (direction == Direction.SOUTH) {
	        nextY = y + 1;
	    }

	    // Check if the robot can move to the next position
	    if (nextX > 0 && nextX < arena.getXsize() - 1 && nextY > 0 && nextY < arena.getYsize() - 1 && arena.canMoveHere(nextX, nextY)) {
	        setXY(nextX, nextY); // Move the robot to the new position if valid
	    } else {
	        direction = direction.getNextDirection(); // Change direction if the move is invalid
	    }
	}
	
	
	
	
	
	public boolean isHere (int sx, int sy) {
		
		if(getX() == sx && getY() == sy ) { // Compare current position with given coordinates
			return true;
		} 
		
		return false;
		}
	
	
	
	//setting new x and y
	public void setXY(int nx , int ny) {
		
		x = nx; // Set new x coordinate
		y = ny; // Set new y coordinate
		
	}

	
	//getters and setters
	public int getX() {
		return x;  // Return the x coordinate
	}
	
	
	public int getY() {
			return y; // Return the y coordinate
		}
		
	

	
	//displaying using toString
	public String toString() {
		
		return "Robot" + robotid + " at " + x + ", " + y + " Direction, " + direction;
	}
	
	
	// Main method to test robot functionality
	public static void main(String[] args) {
		Robot d = new Robot(5, 2,Direction.getRandomDirection());
		System.out.println(d.toString());// print where is
	}
}
	
	

