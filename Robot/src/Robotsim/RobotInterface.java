package Robotsim;
import java.util.Scanner;  // Import the Scanner class



 
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
            System.out.print("Enter (A)dd Robot, get (I)nformation or e(X)it or (D)isplay or (M)ove or S(imulate) or N(ew) or Y(Save) L(oad)> ");
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
                    
                    
                case 'N' :
                case 'n' :
                	createNewArena();  // call createNewArena
                	doDisplay();
                    break; 
                    
                case 'L':
                case 'l':
                    loadFile();    // Load the arena from a file
                    doDisplay();   // Optionally display the arena after loading
                    break;
               
                case 'Y' :
                case 'y' :
                    saveArena();    // Save the current state of the arena
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
    
    public void createNewArena() {
    	
    	// Prompt for arena dimensions
    	System.out.print("Enter new arena width: ");
        int x = s.nextInt();  // Get width from user

        System.out.print("Enter new arena height: ");
        int y = s.nextInt();  // Get height from user
        
         myArena = new RobotArena(x, y,Direction.getRandomDirection());
         System.out.println("New arena created with dimensions " + x + "x" + y);
    	
    }
    
	public static void main(String[] args) {
		RobotInterface r = new RobotInterface();	// just call the interface
	}
    
    
	public void saveArena() {
	    TextFile tf = new TextFile("Text files", "txt");
	    
	    if (tf.createFile()) { // if file is successfully created or chosen
	      
	    	 // Retrieve the string representation of the arena
	        String arenaData = myArena.toString();
	        
	        tf.writeAllFile(arenaData);  // Write the arena data to the file
	        System.out.println("Arena saved successfully to " + tf.usedFileName());
	    } else {
	        System.out.println("Failed to create or select a file.");
	    }
	    tf.closeFile(); // close file
	}


    	
    	
     
    public void loadFile() {
    	
    	TextFile tf = new TextFile("Text files", "txt"); // Ensure this class is set up for opening files
    	 
    	
        if (tf.openFile()) {  // This opens the dialog and lets the user pick a file to open
            String fs = tf.readAllFile();  // Reads the whole file
            if (!fs.isEmpty()) {
                fs = fs.substring(0, fs.length() - 1);  // Safely remove the last newline character if it exists
            }
      
            
            //sets new
            myArena = new RobotArena(fs); 
    	
        }
    
   	
}
    
}
