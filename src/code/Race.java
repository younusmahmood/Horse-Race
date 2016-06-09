/*
 * Author: Younus Mahmood
 * Race.java
 */

package code;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class Race {
	DisplayStrategy display;  // You need to use the Display strategy to display your results
	List<Horse> enrolledHorses = new ArrayList<Horse>();
	Horse champ;
	public Race() {
		display = new GUIDisplay();  // Instantiate the display strategy.  		
	}
	
	public void setupRace() throws InterruptedException{	
		
		
		Race race = new Race();
		race.EnrollOneHorse("Michael Jordan",0,22,new EarlySprintStrategy());
		race.EnrollOneHorse("Kevin Durant",1,24,new SlowStartStrategy());
		race.EnrollOneHorse("LeBron James",2,25,new EarlySprintStrategy());
		race.EnrollOneHorse("Stephen Curry",3,25,new SlowStartStrategy());
		race.EnrollOneHorse("Derrick Rose",4,25,new SteadyRunStrategy());	
		race.runRace(); 
		
	}
	
	/**
	 * This method is used by the test case to enroll one horse in the race.
	 * 
	 * @param horseName
	 * @param horseNumber
	 * @param maxSpeed
	 * @param strategy
	 * @param horsePosition
	 * @param flag
	 */
	public void EnrollOneHorse(String horseName, double horseNumber, double maxSpeed, RaceStrategy strategy){		
		Horse myHorse = new Horse(horseName, horseNumber, maxSpeed, strategy) ;		
		enrolledHorses.add(myHorse);
	}
	
	public Horse getWinner(){
		return champ;  // Obviously you won't return a new horse here!!!  It is a stub
	}
		
	public void runRace() throws InterruptedException 
	{
		boolean won = false;
		
		while(!won){
		//for(int i = 0; i < enrolledHorses.size();i++)
		for(Horse horses: enrolledHorses){
			//RaceTrack.setHorsePosition(i, );
			System.out.print(horses.getHorsename() + " has run ");
			System.out.println((int)horses.getHorsePosition()/100 + " Miles");
			horses.runHorse();
			Thread.sleep(40);
			display.setHorsePosition(horses.getHorsename() , (int)horses.getHorseNumber(),  (int)horses.getHorsePosition());
			if(horses.horsePosition >= 1000){
				horses.flag = true;
				champ = horses;
				System.out.println("The winner is: " + champ.horseName);
				won = true;
				display.awardTrophy((int)horses.getHorseNumber(), horses.getHorsename());
				break;	
			}
		}
		}
		
	}	
	
}
