package com.idt.contest.highschool.winter2014;
/**
 * A Function to test equality. Isolated from Builder, because it is a fundamental component.
 */
public class Equals<A> implements Function<A>{
	/**
	 * Generic to be tested.
	 */
	A toTest;

	/**
	 * Set the Generic that will be tested.
	 */
	public Equals(A a){
		this.toTest = a;
	}

	/**
	 * Test method required by Function.
	 * @param a Generic that will be tested against toTest.
	 */
	public boolean test(A a){
		return this.toTest.equals(a);
	}
}
