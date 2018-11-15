package myMath;

import java.util.Comparator;
/**
 * this class represente a Comperator 
 * @author Netanel
 *
 */
public class Monom_Comperator implements Comparator<Monom> {
	@Override
	/**
	 * Compare by powers
	 */
	public int compare(Monom firstM, Monom secondM) {  //first monom and second monom
		if(firstM.get_power() > secondM.get_power())   //compare by power
			return 1;
		if(firstM.get_power() < secondM.get_power())
			return -1;
		return 0;
	}

	
	

}
