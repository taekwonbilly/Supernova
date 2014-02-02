package com.idt.contest.highschool.winter2014;

public class Expectation<A> {
	boolean initCondition;
	Function<A> finalCondition;
	StackTraceElement creationLocation;
	public Expectation(StackTraceElement creationLocation, boolean init, Function<A> fin){
		this.creationLocation = creationLocation;
		this.initCondition = init;
		this.finalCondition = fin;
	}

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
