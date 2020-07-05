package game;

/**
 * Class for a time object
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it3
 */
public class Time {
	
	/**
	 * time of the white player as an integer
	 */
	public int timeWhite;
	
	/**
	 * time of the black player as an integer
	 */
	public int timeBlack;
	
	/**
	 * check if time object is active
	 */
	public boolean active;
	
	/**
	 * constructor of a time object
	 * @param white white's time in seconds
	 * @param black black's time in seconds
	 */
	public Time(int white, int black) {
		this.timeWhite = white;
		this.timeBlack = black;
		this.active = false;
	}
	
	/**
	 * method to update the time
	 * @param brett board the game is on
	 */
	public void updateTime(Board brett) {
		if((this.timeWhite > 0 || timeBlack > 0)&& this.active) {
			if(brett.getCurrentTurn() == 0) {
				timeWhite = timeWhite - 1;
			}
			if(brett.getCurrentTurn() == 1) {
				timeBlack = timeBlack - 1;
			}
		}
		if(this.timeWhite == 0 || this.timeBlack == 0) {
			this.active = false;
		}
		
	}
}
