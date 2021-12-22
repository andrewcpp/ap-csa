// Flag starter kit

/*
 * Andrew Chang
 * Michael Chen
 * F Period APCSA
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Flag extends JApplet {
	private final int STRIPES = 13;

	// SCALE FACTORS (A through L)
	//
	// Note: Constants in Java should always be ALL_CAPS, even
	// if we are using single letters to represent them
	//
	// NOTE 2: Do not delete or change the names of any of the
	// variables given here
	//
	// Set the constants to exactly what is specified in the documentation
	// REMEMBER: These are scale factors.  They are not numbers of pixels.
	// You will use these and the width and height of the Applet to figure
	// out how to draw the parts of the flag (stripes, stars, field).
	private final double A = 1.0;  // Hoist (width) of flag
	private final double B = 1.9;  // Fly (length) of flag
	private final double C = 0.5385;  // Hoist of Union
	private final double D = 0.76;  // Fly of Union
	private final double E = 0.054;  // See flag specification
	private final double F = 0.054;  // See flag specification
	private final double G = 0.063;  // See flag specification
	private final double H = 0.063;  // See flag specification
	private final double K = 0.0616;  // Diameter of star
	private final double L = 0.0769;  // Width of stripe

	// You will need to set values for these in paint()
	private double flag_width;   // width of flag in pixels
	private double flag_height;  // height of flag in pixels
	private double stripe_height; // height of an individual stripe in pixels

	// init() will automatically be called when an applet is run
	public void init () {
		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		setSize(760, 400);
		repaint();
	}

	// paint() will be called every time a resizing of an applet occurs
	public void paint (Graphics g) {
		// set flag height and width depending on the window size
		if (getWidth() >= B * getHeight()) {
			flag_height = getHeight();
			flag_width = (int) (getHeight() * B);
		} else {
			flag_width = getWidth();
			flag_height = getWidth() / B;
		}
		drawBackground(g);
		
		// hide a little bit of a black background showing due to integer-rounding offset in the flag stripes
		g.setColor(Color.red);
		g.fillRect(0, 0, (int) flag_width, (int) flag_height);
		drawStripes(g);
		drawField(g);
		
		// x and y coordinates of the top left star
		int topLeftX = (int) (flag_height * G);
		int topLeftY = (int) (flag_height * E);
		int starRadius = (int) (flag_height * K / 2);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 11; j++) {
				if (i % 2 == 0 && j % 2 == 1) continue;
				if (i % 2 == 1 && j % 2 == 0) continue;
				int centerX = (int) (topLeftX + j * flag_height * H);
				int centerY = (int) (topLeftY + i * flag_height * F);
				drawStars(g, centerX, centerY, starRadius);
			}
		}
	}

	private void drawBackground (Graphics g) {
		// set black background
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void drawStripes (Graphics g) {
		// stripe height is times L of flag height
		stripe_height = (int) (flag_height * L);
		
		// generate each stripe, alternating colors
		for (int i = 0; i < STRIPES; i++) {
			if (i % 2 == 0) g.setColor(Color.red);
			else g.setColor(Color.white);
			
			g.fillRect(0, (int) flag_height * i / 13, (int) flag_width, (int) stripe_height);
		}
	}

	public void drawField (Graphics g) {
		// blue union field of the flag
		g.setColor(Color.blue);
		g.fillRect(0, 0, (int) (D * flag_height), (int) (C * flag_height));
	}
	
	public void drawStars (Graphics g, int centerX, int centerY, int starRadius) {
		int[] xPoints = new int[10];
		int[] yPoints = new int[10];
		g.setColor(Color.white);
		
		// outer points of the star
		for (int i = 0; i < 10; i += 2) {
			xPoints[i] = (int) (centerX + Math.cos(i * 2 * Math.PI / 5 - Math.PI / 10) * starRadius);
			yPoints[i] = (int) (centerY + Math.sin(i * 2 * Math.PI / 5 - Math.PI / 10) * starRadius);
		}
		
		// inner points of the star
		for (int i = 1; i < 10; i += 2) {
			xPoints[i] = (int) (centerX + Math.cos(i * 2 * Math.PI / 5 + Math.PI / 10) * starRadius * 0.382);
			yPoints[i] = (int) (centerY + Math.sin(i * 2 * Math.PI / 5 + Math.PI / 10) * starRadius * 0.382);
		}
		g.fillPolygon(xPoints, yPoints, 10);
		
		// fill the inner pentagon
		int[] innerXPoints = new int[5];
		int[] innerYPoints = new int[5];
		
		for (int i = 0; i < 5; i ++) {
			innerXPoints[i] = (int) (centerX + Math.cos(i * 2 * Math.PI / 5 + Math.PI / 10) * starRadius * 0.382);
			innerYPoints[i] = (int) (centerY + Math.sin(i * 2 * Math.PI / 5 + Math.PI / 10) * starRadius * 0.382);
		}
		g.fillPolygon(innerXPoints, innerYPoints, 5);
	}
}