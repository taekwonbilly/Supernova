package com.idt.contest.highschool.winter2014;

/**
 * The Expectation object tests a particular object using a function to make sure that the result is correct.
 */
public class Expectation<A> {
	/**
	 *  Used to determine whether or not testing should be active. If testing not active, don't run any of this.
	 */
	boolean initCondition;
	/**
	 * Used to validate a particular object.
	 */
	Function<A> finalCondition;
	/**
	 * Location in stack to provide robust error logging.
	 */
	StackTraceElement creationLocation;
	/**
	 * Constructor for Expectation objects.
	 * @param creationLocation Part of stack where it was created for robust error logging.
	 * @param init Boolean to determine whether or not the testing framework should be active.
	 * @param fin Function to test objects against.
	 */
	public Expectation(StackTraceElement creationLocation, boolean init, Function<A> fin){
		this.creationLocation = creationLocation;
		this.initCondition = init;
		this.finalCondition = fin;
	}

	/**
	 * Verifies that a passed object, when acted upon by fin is true. If not, error log. 
	 * @param a Object to test.
	 * @return Returns the object passed in.
	 */
	public A verify(A a){
		String message;
		boolean failed;
		if(initCondition==false){
			message = "Test not run: Initial condition not true";
			failed = false;
		} else {
			failed = !finalCondition.test(a);
			message = (failed)?(a.toString()+" did not meet final condition"):(a.toString()+"did meet final condition");

			StackTraceElement[] stack = Thread.currentThread().getStackTrace();
			StackTraceElement verification = stack[stack.length-1];
			message+="when verified on line "+verification.getLineNumber()+" of file \""+verification.getFileName()+"\"";
		}
		Logger.log(creationLocation, message, failed);
		return a;
	}
}
