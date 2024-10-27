package Robotsim;
import java.util.Scanner;



 
public class RobotInterface {
	
	private Scanner s;								// scanner used for input from user
    private RobotArena myArena;				// arena in which Robots are shown
    /**
    	 * constructor for RobotInterface
    	 * sets up scanner used for input and the arena
    	 * then has main loop allowing user to enter commands
     */
    public RobotInterface() {
    	 s = new Scanner(System.in);			// set up scanner for user input
    	 myArena = new RobotArena(20, 6 ,Direction.getRandomDirection());	// create arena of size 20*6
    	
        char ch = ' ';
        do {
            System.out.print("Enter (A)dd Robot, get (I)nformation or e(X)it or (D)isplay or (M)ove S(imulate)> ");
            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A' :
                case 'a' :
                    myArena.addRobot();    // add a new Robot to arena
                    break;
                case 'I' :
                case 'i' :
                    System.out.print(myArena.toString());
                    break;
                case 'x' : 
                    ch = 'X';              // when X detected program ends
                    break;
                case 'D' :
                case 'd' :
                    doDisplay();           // Call the doDisplay() method to display the arena with robots
                    break;       
                    
                case 'M' :
                case 'm' :
                	myArena.moveAllRobots();          
                	doDisplay();
                    break; 
                    
                case 'S' :
                case 's' :
                	myArena.animation(10);          
                	doDisplay(); // Call the doDisplay() method to display the arena with robots
                    break;
            }
        } while (ch != 'X');                // test if end
        
        s.close();                          // close scanner
    }
    
    
    /**
    /**
    * Display the Robot arena on the console
    *
    */
    
    void doDisplay() {
    	
    	// determine the arena size
    	int x = myArena.getXsize();
    	int y = myArena.getYsize();
    	ConsoleCanvas cc = new ConsoleCanvas(x, y, "32001832");

    	// call showRobots suitably
    	myArena.showRobots(cc);
    	
    	// then use the ConsoleCanvas.toString method
    	 System.out.println(cc.toString());   
    
    
    }
    
    
    
    
    
	public static void main(String[] args) {
		RobotInterface r = new RobotInterface();	// just call the interface
	}

	
	
	
	
}