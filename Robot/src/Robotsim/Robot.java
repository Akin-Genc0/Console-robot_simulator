package Robotsim;



public class Robot {

	
	private int x,y, robotid, dx, dy;
	private static int Robotcout = 0;
	
	
	public Robot (int rx , int ry) {
		x = rx;
		y = ry;
		
		robotid = Robotcout++;
		dx = 1;
		dy = 1;
		
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
		
		return "Robot" + robotid + " at " + x + ", " + y;
	}
	
	public static void main(String[] args) {
		Robot d = new Robot(5, 3); // create Robot
		System.out.println(d.toString());// print where is
	}
	
	
	
	public boolean isHere (int sx, int sy) {
		
		if(getX() == sx && getY() == sy ) {
			return true;
		} 
		
		return false;
		}
	
}
