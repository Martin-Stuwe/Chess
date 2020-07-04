package game;

public class Time {
	
	public int timeWhite;
	
	public int timeBlack;
	
	public boolean active;
	
	
	public Time(int white, int black) {
		this.timeWhite = white;
		this.timeBlack = white;
		this.active = false;
	}
	
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
