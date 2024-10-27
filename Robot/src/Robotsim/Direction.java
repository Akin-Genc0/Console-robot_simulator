package Robotsim;
import java.util.Random;

public enum Direction {

	NORTH,
	SOUTH,
	EAST,
	WEST;
	
	
	
	public static Direction getRandomDirection() {
		  Random random = new Random(); 
          return values()[random.nextInt(values().length)];
	}
	
	
	
	public Direction getNextDirection() {
		
		switch(this) {
		case NORTH: return EAST;
        case EAST: return SOUTH;
        case SOUTH: return WEST;
        case WEST: return NORTH;
		  default: return Direction.getRandomDirection();
		    
		}
		 
	      
	        
	}
	
	
	
}
