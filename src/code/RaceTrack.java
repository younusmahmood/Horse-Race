package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class RaceTrack extends JPanel{
	
	Rectangle[] horsePosition;  // Represents the horse
	Color[] jockeyColors;  // Horse colors
	int horseCount;
	boolean showTrophy;
	int winningHorse;
	String winningHorseName;
	
	/**
	 * Constructor.  Called by GUIDisplay.java
	 * Constructs the race track and racing horses
	 * @param horseCount
	 */
	public RaceTrack(int horseCount){
		 horsePosition = new Rectangle[horseCount];
		
		 for(int j = 0; j < horseCount; j++){
			 horsePosition[j] = new Rectangle();
			 horsePosition[j].setLocation(10,10+(j*50));
		 }
	     this.horseCount = horseCount;
		 jockeyColors = new Color[horseCount];	 
		 initColors();
		 showTrophy = false;
		
	}
	
	/**
	 * Displays winner message
	 * @param horseNumber
	 * @param winningName
	 */
	public void awardTrophy(int horseNumber, String winningName)
	{
		showTrophy = true;
		winningHorse = horseNumber;
		winningHorseName = winningName;
		validate();
		repaint();
		
	}
	
	/**
	 * Updates the position of each horse during the race
	 * @param horseNumber
	 * @param raceTrackPosition
	 */
	public void setHorsePosition(int horseNumber, int raceTrackPosition){
		horsePosition[horseNumber].x = raceTrackPosition;
		validate();
		repaint();
	}
	
	/**
	 * Establishes 6 possible jockey colors.  Add more here if you want to increase
	 * race size above 6
	 */
	public void initColors(){
		jockeyColors = new Color[6];
		jockeyColors[0] = Color.RED;
		jockeyColors[1] = Color.ORANGE;
		jockeyColors[2] = Color.GREEN;
		jockeyColors[3] = Color.CYAN;
		jockeyColors[4] = Color.YELLOW;
		jockeyColors[5] = Color.red;		
	}
	
	 /* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setFont(new Font("TimesRoman", Font.BOLD, 24));
		 g2.setPaint(Color.WHITE);
		 g2.setColor(Color.WHITE);
		 for(int j = 0; j < horseCount; j++){
			 g2.fillRect (0, horsePosition[j].y, horsePosition[j].x,25);
		 }
		 g2.setColor(Color.BLACK);
		 
		 g2.drawLine(1000,10,1000,250);
		 for(int j = 0; j < horseCount; j++){
			 g2.setPaint(jockeyColors[j]);
			 g2.fillRect (horsePosition[j].x, horsePosition[j].y, 25, 25);
			 g2.setColor(Color.BLACK);
			 g2.drawString(Integer.toString(j), horsePosition[j].x+10,horsePosition[j].y+20);
			// System.out.println("New position " + horsePosition[j].x + " " +horsePosition[j].y);
		 }
		 if (showTrophy) {			
		     g2.setColor(Color.BLACK);
		 	 g2.drawString(winningHorseName + " wins!!!", horsePosition[winningHorse].x+30, horsePosition[winningHorse].y+20);//horsePosition[winningHorse].y, horsePosition[winningHorse].x+50);
		 }
		 repaint();
    }	
}
