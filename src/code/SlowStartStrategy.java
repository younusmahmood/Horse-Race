package code;

/**
 * The jockey runs the horse at 75% of its maximum speed and then increases to full speed for the
 * last 3 miles
 *
 */
public class SlowStartStrategy implements RaceStrategy{

	@Override
	public double runStrategy(double position, double maxSpeed) {
		
		if(position < 600){
			return  maxSpeed*(.75);
		}
		else if(position >= 600){
			return  maxSpeed*(.90);			
		}
		else{
			return  maxSpeed;
		}
		
	}
	
}
