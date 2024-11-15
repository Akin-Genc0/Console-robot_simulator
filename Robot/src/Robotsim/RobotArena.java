package Robotsim;


import java.util.ArrayList;
import java.util.Random;


 

public class RobotArena {

	  // List to hold all robots
	private ArrayList<Robot> manyRobots;
	Random randomGenerator; // Initialise a random generator  
	
	private int maxX , maxY;  // Dimensions of the arena
	private Robot R; 
	private Direction dir;
	
	
	 // Constructor initialising the arena with specified dimensions and a default direction
	
	 public RobotArena(int maxX, int maxY, Direction dir ) {
		manyRobots = new ArrayList<Robot>();
		this.maxX = maxX;
		this.maxY = maxY;
		randomGenerator = new Random();
		
		
	    }
	 
	 




	void addRobot() {
		    while (true) {
		    	
		    	
		    	int rx = randomGenerator.nextInt(maxX -2 ) + 1; // generate a random x-coordinate within the bounds
		    	int ry = randomGenerator.nextInt(maxY -2) + 1; // generate a random y-coordinate within the bounds

		    	 
		    	 
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
			 
			 R.displayRobot(c); // Display each robot on the canvas
		 }
	 }
	 
	
	public String toString() {
		
		 // Initialise the result string with the arena size
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
	      System.out.println(toString());   // Redraw the arena to show new positions

	        // Delay to create animation effect
	        try {
	            Thread.sleep(200);      // 200ms delay
	        } catch (InterruptedException e) {
	            System.out.println("Animation interrupted");
	        }
	    }
	}

	
	
	
	public Robot getRobotAt(int x, int y) {
		
		// Iterate over all robots in the list
		for(int i = 0; i < manyRobots.size(); i++) {
			Robot currentRobot = manyRobots.get(i); // Get the robot at index i
			
			 if (currentRobot.isHere(x, y)) {
		            return currentRobot; // Return the robot if it matches the position
		        }
		}
		 return null;	
	}
	
	
	
	
	 public RobotArena(String fs) {
		    manyRobots = new ArrayList<>();
		    randomGenerator = new Random();

		    String[] lines = fs.split("\n"); // Split the input string into lines to process each separately

		    if (lines.length > 0) {
		        String[] dimensions = lines[0].split(" ");
		        if (dimensions.length >= 5) {
		            try {
		            	 // parse the arena dimensions from the specified indices
		                maxY = Integer.parseInt(dimensions[2]);
		                maxX = Integer.parseInt(dimensions[4]);
		            } catch (NumberFormatException e) {
		                System.err.println("Error parsing dimensions: " + e.getMessage());
		                return;
		            }
		        } else {
		        	// If the dimensions line does not contain enough parts, log an error and exit
		            System.err.println("Invalid dimensions line.");
		            return;
		        }

		        // Parse robots from the remaining lines
		        for (int i = 1; i < lines.length; i++) {
		            try {
		                String[] robotDetails = lines[i].split(" at |, | Direction, ");
		                // Expected to split into ["Robot0", "1", "1", "NORTH"]
		                
		                if (robotDetails.length >= 4) {
		                	  // Parse the robot's position (x, y) and direction
		                    int x = Integer.parseInt(robotDetails[1]);
		                    int y = Integer.parseInt(robotDetails[2]);
		                    Direction direction = Direction.valueOf(robotDetails[3]);
		                    
		                    // Create a new Robot object with parsed details and add it to the list
		                    Robot newRobot = new Robot(x, y, direction);
		                    manyRobots.add(newRobot);
		                } else {
		                    System.err.println("Invalid robot data on line " + (i + 1));
		                }
		            } catch (Exception e) {
		                System.err.println("Error parsing robot on line " + (i + 1) + ": " + e.getMessage());
		            }
		        }
		    } else {
		        System.err.println("Empty or invalid file content.");
		    }
		}

	
	
	
	//getter
	 
	public int getXsize() {
		return maxX;
		
	}
	
	public int getYsize() {
		return maxY;
		
	}
	
}


