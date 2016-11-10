import sheffield.*;
public class Picture { 
	public static void main(String[] args) {
		final int PICTURE_WIDTH = 1800;
		final int PICTURE_HEIGHT = 150;
		EasyGraphics g = new EasyGraphics(PICTURE_WIDTH,PICTURE_HEIGHT);
		EasyReader read = new EasyReader("picture.txt");
		char [][] readArray = new char[150][300];
		
		/*Draw the blue background*/
			g.setColor(60,220,245);
			g.fillRectangle(0,0,1800,150);
			
	/*Nested loop to fill readArray with characters read in from the text
	file. It is filled in from top to bottom and from left to right.*/
		for(int height=149; height>=0; height--) {
			for(int width=0; width<300; width++) {
				char c = read.readChar();
				readArray [height][width] = c;
			}
		}
		
	/*Counter used to draw exactly 30 trees. On each loop a random
	x and y variable is generated to spread the trees out*/
		for(int count=0; count<30; count++) {
				int x = (int) (Math.random()*2000)-250;
				int y = (int) (Math.random()*20);
				
		/*Nested loop used to read the array values to draw each tree*/
			for(int height=149; height>=0; height--) {
				for(int width=0; width<300; width++) {	
					
				/*The colour is set according to the array value, and if it
				is 0 then it is ignored.*/
					if(readArray[height][width] == '1') {
						g.setColor(3,255,11);
						g.fillRectangle(width+x,height+y,1,1);
					} else if (readArray[height][width] == '2') {
						g.setColor(153,76,0);
						g.fillRectangle(width+x,height+y,1,1);
					}
					
				}
			}
		}

	}
}