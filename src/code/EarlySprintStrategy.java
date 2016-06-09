package code;

/**
 * The jockey runs the horse at maximum speed for 2 miles and then reduces to 75%
 * @author 
 *
 */
public class EarlySprintStrategy implements RaceStrategy {

	@Override
	public double runStrategy(double position, double maxSpeed) {

		if(position < 200){
			return maxSpeed;
		}
		else {
			return (maxSpeed*.75);
		}
		
	}
	

}
