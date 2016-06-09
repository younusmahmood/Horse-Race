package code;

import javax.swing.JFrame;


public class GUIDisplay implements DisplayStrategy{
	RaceTrack raceTrack;
	public GUIDisplay(){
		JFrame f = new JFrame("BedRock RaceTrack");
		f.setSize(1300, 300);
		raceTrack = new RaceTrack(5);
		f.add(raceTrack);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);	 
	}
	
	public void setHorsePosition(String horseName, int horseNumber, int raceTrackPosition){
		raceTrack.setHorsePosition(horseNumber, raceTrackPosition);				
	}
	
	public void awardTrophy(int horseNumber, String horseName){
		raceTrack.awardTrophy(horseNumber, horseName);
	}
	
}
