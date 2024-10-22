package Robotsim;


import java.util.ArrayList;
import java.util.Random;


 

public class RobotArena {

	
	private ArrayList<Robot> manyRobots;
	Random randomGenerator;
	
	private int maxX , maxY; //how big the arena is gonna be
	private Robot R;
	
	
	
	
	 public RobotArena(int maxX, int maxY) {
		manyRobots = new ArrayList<Robot>();
		this.maxX = maxX;
		this.maxY = maxY;
		randomGenerator = new Random();
		
		
	    }
	 
	 
	
	 void addRobot() {
		
		 while (true) {
		        int rx = randomGenerator.nextInt(maxX); // Generate random x
		        int ry = randomGenerator.nextInt(maxY); // Generate random y
		        
		        // Check if there's already a robot at the generated position
		        if (getRobotAt(rx, ry) == null) {
		            // Position is free, create a new Robot
		            R = new Robot(rx, ry);
		            manyRobots.add(R); // Add the new Robot to the list
		            break; // Exit the loop
		        }
		        // If a robot is found at the position, the loop will repeat
		 }
				
		
	}


	public int getXsize() {
		return maxX;
		
	}
	
	public int getYsize() {
		return maxY;
		
	}
	
	
	public String toString() {
		
		
		String res = "Arena size " + maxX + " by " + maxY + " with " + "\n";
		for(Robot R: manyRobots) res += R.toString()+ "\n";
			
		return res;
		
	}
	
	public static void main(String[] args) {
		RobotArena a = new RobotArena(20, 10); // create Robot arena
		
		
		
		for(int i = 0; i < 5; i++) {
			a.addRobot();
		}
		
		System.out.println(a.toString());// print arena size and where robot is

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
	
}

