package com.idt.contest.highschool.winter2014;

/**
 * Function interface which should be implemented by all functions for testing. The test method should take a generic object and specify when the function should be return true and false. For a list of prebuilt Functions, check the Builder class. For binary checks, see BinaryFunction.
 */
public interface Function<A>{
	/**
	 * Method that should be overwritten by all functions used for testing.
	 * @param a Object that will be tested.
	 */
	public boolean test(A a);
}
