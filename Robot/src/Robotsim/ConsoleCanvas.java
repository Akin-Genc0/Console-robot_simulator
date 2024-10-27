package Robotsim;

public class ConsoleCanvas {
    private char[][] canvas; // 2D array to represent the canvas
    private int width, height; // dimensions of the canvas

    public ConsoleCanvas(int maxX, int maxY, String studentNum) { // constructor with parameters for width, height, and student number
        width = maxX; // set the width of the canvas
        height = maxY; // set the height of the canvas

        canvas = new char[height][width]; // initialize the canvas array

        // Loop through each height of the canvas
        for (int i = 0; i < height; i++) {
            // Loop through each width of the canvas
            for (int j = 0; j < width; j++) {
                // Set border cells to '#'
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    canvas[i][j] = '#';
                } else {
                    canvas[i][j] = ' '; // inner cells set to space
                }
            }
        }

        // Calculate starting position for the student number on the top border
        int startCol = (width - studentNum.length()) / 2;

        // Place each character of the student number on the top border
        for (int k = 0; k < studentNum.length(); k++) {
            canvas[0][startCol + k] = studentNum.charAt(k);
        }
    }


    	public void showIt(int x, int y, char ch) {
    	    // Only display within the inner arena
    	    if (x > 0 && x < width - 1 && y > 0 && y < height - 1) {
    	        canvas[y][x] = ch;
    	    }
    	

    }



    public String toString() {
        String ans = "";
        for (int ct = 0; ct < height; ct++) {
            for (int yc = 0; yc < width; yc++) {
                ans += canvas[ct][yc];
            }
            ans += '\n'; // add newline after each row
        }
        return ans;
    }

    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(25, 10, "32001832"); // create a canvas
        
        System.out.println(c.toString()); // display result
    }
}

