package com.idt.contest.highschool.winter2014;
/**
 * Can be used instead of Function to pass two objects to the same testing function. See the Builder class for some predefined BinaryFunctions.
 */
public interface BinaryFunction<A,B>{
	/**
	 * Similar to Function's test, except takes two objects instead. 
	 * @param a An object to be tested.
	 * @param b Another object to be tested.
	 */
	public boolean test(A a, B b);
}
