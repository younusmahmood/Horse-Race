package code;

public interface DisplayStrategy {
	public void setHorsePosition(String horseName, int horseNumber, int raceTrackPosition);
	public void awardTrophy(int horseNumber, String horseName);
}