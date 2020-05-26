package game;

/**
 * Class for the moves
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Zug {
	
	/**
	 * the figure that has been moved
	 */
	Figures figure;
	
	/**
	 * from where the figure has moved x axis position
	 */
	int from1;
	
	/**
	 * from where the figure has moved y axis position
	 */
	int from2;
	
	/**
	 * where the figure has moved to x axis position
	 */
	int to1;
	
	/**
	 * where the figure has moved to y axis position
	 */
	int to2;
	
	/**
	 * constructor for a zug object
	 * @param figure figure that has been moved
	 * @param from1 x axis position
	 * @param from2 y axis position
	 * @param to1 x axis position
	 * @param to2 y axis position
	 */
	public Zug(Figures figure, int from1, int from2, String to) {  
		this.figure = figure;
		this.from1 = from1;
		this.from2 = from2;
		this.to1 = Character.getNumericValue(to.charAt(0));
		this.to2 = Character.getNumericValue(to.charAt(1));	
	}
	
	/**
	 * get-method for the figure object
	 * @return figure figure of the zug object
	 */
	public Figures getFigure() {
		return this.figure;
	}
	
	/**
	 * get-method for the integer from1
	 * @return from1 from1 integer of the zug object
	 */
	public int getFrom1() {
		return this.from1;
	}
	
	/**
	 * get-method for the integer from2
	 * @return from2 from2 integer of the zug object
	 */
	public int getFrom2() {
		return this.from2;
	}
	
	/**
	 * get-method for the integer to1
	 * @return to1 to1 integer of the zug object
	 */
	public int getTo1() {
		return this.to1;
	}
	
	/**
	 * get-method for the integer to2
	 * @return to2 to2 integer of the zug object
	 */
	public int getTo2() {
		return this.to2;
	}

}
