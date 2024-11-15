package Robotsim;
import java.util.Random;

public enum Direction {

	//setting durections
    NORTH,
    SOUTH,
    EAST,
    WEST;

    // Method to get a random direction from the enum values
    public static Direction getRandomDirection() {
        Random random = new Random(); // Create an instance of Random
        return values()[random.nextInt(values().length)]; // Return a random Direction
    }

    // Method to get the next direction based on the current direction
    public Direction getNextDirection() {
        // Use a switch statement to determine the next direction
        switch(this) {
        case NORTH: return EAST; // If current is NORTH, return EAST
        case EAST: return SOUTH; // If current is EAST, return SOUTH
        case SOUTH: return WEST; // If current is SOUTH, return WEST
        case WEST: return NORTH; // If current is WEST, return NORTH
        default: return Direction.getRandomDirection(); // Default to a random direction  
        }
    }
}

