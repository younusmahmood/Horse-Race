package tc;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.LinkedList;

import code.EarlySprintStrategy;
import code.GUIDisplay;
import code.Horse;
import code.Race;
import code.SlowStartStrategy;
import code.SteadyRunStrategy;

import org.junit.Test;

public class RaceTest {

	@Test
	public void testRace1(){
		try {
			Race race = new Race();
			race.EnrollOneHorse("Sam",0,22,new EarlySprintStrategy());
			race.EnrollOneHorse("Molly",1,24,new SlowStartStrategy());
			race.EnrollOneHorse("Joe",2,25,new EarlySprintStrategy());
			race.EnrollOneHorse("Blizzard",3,25,new SlowStartStrategy());
			race.EnrollOneHorse("Flicker",4,25,new SteadyRunStrategy());	
			race.runRace();
			Horse winner = race.getWinner();
			assertEquals(winner.getHorsename(),"Blizzard");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testRace2(){
		try {
			Race race = new Race();
			race.EnrollOneHorse("Sam",0,22,new EarlySprintStrategy());
			race.EnrollOneHorse("Molly",1,22,new EarlySprintStrategy());
			race.runRace();
			Horse winner = race.getWinner();
			assertEquals(winner.getHorsename(),"Sam");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testRace3(){
		try {
			Race race = new Race();
			race.EnrollOneHorse("Sam",0,100,new EarlySprintStrategy());
			race.EnrollOneHorse("Molly",1,100,new SlowStartStrategy());
			race.runRace();
			Horse winner = race.getWinner();
			assertEquals(winner.getHorsename(),"Sam");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRace4(){
		try {
			Race race = new Race();
			race.EnrollOneHorse("Sam",0,100,new EarlySprintStrategy());
			race.EnrollOneHorse("Molly",1,100,new SlowStartStrategy());
			race.runRace();
			Horse winner = race.getWinner();
			assertEquals((int)winner.getHorseNumber(),0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
