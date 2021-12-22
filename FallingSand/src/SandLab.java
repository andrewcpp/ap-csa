import java.awt.*;
import java.util.*;

public class SandLab {

	public static void main(String[] args) {
		SandLab lab = new SandLab(120, 80);
		lab.run();
	}

	//add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;
	public static final int GRASS = 4;
	public static final int ICE = 5;

	//do not add any more fields
	private int[][] grid;
	private SandDisplay display;

	public SandLab (int numRows, int numCols) {
		String[] names;
		names = new String[6];
		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[SAND] = "Sand";
		names[WATER] = "Water";
		names[GRASS] = "Grass";
		names[ICE] = "Ice";
		display = new SandDisplay("Falling Sand", numRows, numCols, names);
		grid = new int[numRows][numCols];
	}

	// called when the user clicks on a location using the given tool
	private void locationClicked (int row, int col, int tool) {
		grid[row][col] = tool;
	}

	// copies each element of grid into the display
	public void updateDisplay () {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == EMPTY) display.setColor(i, j, Color.BLACK);
				if (grid[i][j] == METAL) display.setColor(i, j, Color.GRAY);
				if (grid[i][j] == SAND) display.setColor(i, j, Color.YELLOW);
				if (grid[i][j] == WATER) display.setColor(i, j, Color.BLUE);
				if (grid[i][j] == GRASS) display.setColor(i, j, Color.GREEN);
				if (grid[i][j] == ICE) display.setColor(i, j, Color.CYAN);
			}
		}
	}

	//called repeatedly.
	//causes one random particle to maybe do something.
	public void step () {
		Random randomParticle = new Random(new Date().getTime());
		int randomRow = randomParticle.nextInt(grid.length);
		int randomColumn = randomParticle.nextInt(grid[0].length);
		if (grid[randomRow][randomColumn] == SAND && grid[randomRow+1][randomColumn] == EMPTY) {
			grid[randomRow][randomColumn] = EMPTY;
			grid[randomRow+1][randomColumn] = SAND;
		}
		if (grid[randomRow][randomColumn] == SAND && grid[randomRow+1][randomColumn] == WATER) {
			grid[randomRow][randomColumn] = WATER;
			grid[randomRow+1][randomColumn] = SAND;
		}
		if (grid[randomRow][randomColumn] == WATER) {
			int randomWaterSeed = randomParticle.nextInt(3);
			if (randomWaterSeed == 0 && grid[randomRow][randomColumn-1] == EMPTY) {
				grid[randomRow][randomColumn] = EMPTY;
				grid[randomRow][randomColumn-1] = WATER;
			} else if (randomWaterSeed == 1 && grid[randomRow+1][randomColumn] == EMPTY) {
				grid[randomRow][randomColumn] = EMPTY;
				grid[randomRow+1][randomColumn] = WATER;
				
			} else if (randomWaterSeed == 2 && grid[randomRow][randomColumn+1] == EMPTY) {
				grid[randomRow][randomColumn] = EMPTY;
				grid[randomRow][randomColumn+1] = WATER;
				
			}
		}
	}

	//do not modify
	public void run () {
		while (true) {
			for (int i = 0; i < display.getSpeed(); i++) step();
			updateDisplay();
			display.repaint();
			display.pause(1);  //wait for redrawing and for mouse
			int[] mouseLoc = display.getMouseLocation();
			if (mouseLoc != null) locationClicked(mouseLoc[0], mouseLoc[1], display.getTool()); //test if mouse clicked
		}
	}

}
