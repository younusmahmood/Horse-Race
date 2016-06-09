package code;

/**
 * Runs at 80% of maximum speed throughout the race.
 *
 */
public class SteadyRunStrategy implements RaceStrategy {

	@Override
	public double runStrategy(double position, double maxSpeed) {
		
		return( maxSpeed * (.80));
		
	}

	
}
