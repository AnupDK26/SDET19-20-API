package sdet.GenericUtils;

import java.util.Random;

/**
 * This class contains generic methods wrt Java
 * @author Chaitra
 *
 */
public class JavaUtility {
	
	/**
	 * This method will return a random number 
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random=ran.nextInt(1000);
		return random;
	}

}
