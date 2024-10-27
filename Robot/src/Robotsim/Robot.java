package Robotsim;



public class Robot {

	
	private int x,y, robotid, dx, dy;
	private static int Robotcout = 0;
	private Direction direction;
	
	public Robot (int rx , int ry,  Direction direction) {
		x = rx;
		y = ry;
		
		robotid = Robotcout++;
		dx = 1;
		dy = 1;
		
		this.direction = direction;
		
	}
	
	/**
	* display the Robot in the canvas
	* @param c the canvas used
	*/
	
	public void displayRobot(ConsoleCanvas c) {
		
		   int x = getX();
		   int y = getY();
		
		//Call `showIt` on the ConsoleCanvas object `c` to place 'R'
		c.showIt(x, y , 'R');
		
		 
	
		}
	
	
	
	
	public void tryToMov(RobotArena arena) {
	    // Get the current position and calculate the next position based on the direction
	    int nextX = x;
	    int nextY = y;

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
		
		if(getX() == sx && getY() == sy ) {
			return true;
		} 
		
		return false;
		}
	

	
	//getters and setters
	public int getX() {
		return x;
	}
	
	
	public int getY() {
			return y;
		}
		
	
	//setting new x and y
	public void setXY(int nx , int ny) {
		
		x = nx;
		y = ny;
		
	}
	
	//displaying using toString
	public String toString() {
		
		return "Robot" + robotid + " at " + x + ", " + y + " Direction, " + direction;
	}
	
	public static void main(String[] args) {
		Robot d = new Robot(5, 2,Direction.getRandomDirection());
		System.out.println(d.toString());// print where is
	}
}
	
	

