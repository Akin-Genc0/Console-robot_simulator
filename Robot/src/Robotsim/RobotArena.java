package Robotsim;


import java.util.ArrayList;
import java.util.Random;


 

public class RobotArena {

	
	private ArrayList<Robot> manyRobots;
	Random randomGenerator;
	
	private int maxX , maxY; //how big the arena is gonna be
	private Robot R;
	private Direction dir;
	
	
	
	 public RobotArena(int maxX, int maxY, Direction dir ) {
		manyRobots = new ArrayList<Robot>();
		this.maxX = maxX;
		this.maxY = maxY;
		randomGenerator = new Random();
		
		
	    }
	 
	 
	
	 void addRobot() {
		    while (true) {
		    	int rx = randomGenerator.nextInt(maxX -2 ) + 1;
		    	int ry = randomGenerator.nextInt(maxY -2) + 1;

		    	 
		    	 
		        // Check if there's already a robot at the generated position
		        if (getRobotAt(rx, ry) == null) {
		            // Generate a random direction
		            Direction randomDirection = Direction.getRandomDirection();
		            
		            // Create a new Robot with the random direction
		            R = new Robot(rx, ry, randomDirection);
		            manyRobots.add(R); // Add the new Robot to the list
		            break; // Exit the loop
		        }
		    }
		}



	
	 /**
	 * show all the Robots in the interface
	 * @param c the canvas in which Robots are shown
	 */
	 public void showRobots(ConsoleCanvas c) {
	
		 for(Robot R: manyRobots) {
			 
			 R.displayRobot(c);
		 }
	 }
	 
	
	public String toString() {
		
		
		String res = "Arena size " + maxX + " by " + maxY + " with " + "\n";
		for(Robot R: manyRobots) res += R.toString()+ "\n";
			
		return res;
		
	}
	
	public static void main(String[] args) {
		RobotArena a = new RobotArena(20, 10, Direction.getRandomDirection()); // create Robot arena
		
		
		
		for(int i = 0; i < 5; i++) {
			a.addRobot();
		}
		
		System.out.println(a.toString());// print arena size and where robot is

}
	
	public boolean canMoveHere(int x, int y) {
		
		
		if( x >= maxX  || x < 0 || y < 0 || y >= maxY) {
			return false;
		}
		
		else if (getRobotAt(x,y) == null) {
			return true;
		}
		
			return false;
	}
	
	
	/**
	 * Moves all robots in the arena by calling each robot's tryToMov method.
	 * Each robot will attempt to move based on its direction and the arena's boundaries.
	 * If a robot encounters an obstacle or boundary, it will change direction.
	 */
	
	public void moveAllRobots() {
		
		
		// Loop through each robot in the list of robots
		for(Robot R: manyRobots) {
			
			// Attempt to move each robot, passing this arena instance as a parameter
			R.tryToMov(this);
		}
		
	}
	

	public void animation(int nTimes) {
	    for (int i = 0; i < nTimes; i++) {
	      moveAllRobots();  // Move all robots once
	      System.out.println(toString());              // Redraw the arena to show new positions

	        // Delay to create animation effect
	        try {
	            Thread.sleep(200);      // 200ms delay
	        } catch (InterruptedException e) {
	            System.out.println("Animation interrupted");
	        }
	    }
	}

	
	
	
	public Robot getRobotAt(int x, int y) {
		
	
		for(int i = 0; i < manyRobots.size(); i++) {
			
			
			Robot currentRobot = manyRobots.get(i); // Get the robot at index i
			
			 if (currentRobot.isHere(x, y)) {
		            return currentRobot; // Return the robot if it matches the position
		        }
			
		}

		 return null;
		
		
	}
	
	
	
	 
	public int getXsize() {
		return maxX;
		
	}
	
	public int getYsize() {
		return maxY;
		
	}
	
}



