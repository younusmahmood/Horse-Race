package code;

public class Horse {
	
	String horseName;
	double horseSpeed;
	double horseNumber;
	double horsePosition = 10;
	RaceStrategy strategy;
	boolean flag = false;
	
	public Horse(String horseName, double horseNumber, double maxSpeed, RaceStrategy strategy){
		
		this.horseName = horseName;
		this.horseSpeed = maxSpeed;
		this.strategy = strategy;
		this.horseNumber = horseNumber;
		
	}
	
	public String getHorsename(){
		return this.horseName;
	}
	
	public double getHorseNumber(){
		return this.horseNumber;
	}
	
	public double getHorseSpeed(){
		return this.horseSpeed;
	}
	
	public RaceStrategy getRaceStrategy(){
		return this.strategy;
	}
	
	public double getHorsePosition(){
		return this.horsePosition;
	}
	
	public void runHorse(){
		this.horsePosition += strategy.runStrategy(horsePosition,horseSpeed);
	}	
	
	
	
}

