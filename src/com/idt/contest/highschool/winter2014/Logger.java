package com.idt.contest.highschool.winter2014;

import java.io.PrintWriter;
import java.io.File;
import java.util.*;
import java.text.*;
public class Logger {
	/***
		File to print logging information to
		Will not print to file if null
	**/
	private static PrintWriter output=null;
	/***
		Boolean denoting whether to print logging information to standard error
	**/
	private static boolean terminal = true;
	/***
		Boolean representing whether the testing information is being printed at all
	**/
	private static boolean disabled=false;
	/***
		Allows one to set the file to which the output information is printed
		Use the argument null to disable printing to file
		@param f The file which can the logger will write to
	**/
	public static void setFile(File f){
		if(output!=null){
			output.close();
		}
		try{
			if(f!=null)
				output = new PrintWriter(f);
			else
				output=null;
		}catch(Exception e){
			System.err.println("Could find or create file '"+f+"' for use in logger -- terminating");
			System.exit(1);
		}
		return;
	}
	/***
		Helper routine that sets the file to which the output information is printed
		@param s A string representing the path to a file where the logger will write to
	**/
	public static void setFile(String s){
		setFile(new File(s));
		return;
	}

	/***
		Enables the error checking system
	**/
	public static void enable(){
		disabled=false;
		return;
	}

	/***
		Disables the error checking system
	**/
	public static void disable(){
		disabled=true;
		return;
	}

	/***
		Method that enables or disables whether logging information is also written to standard error
		A value of true means that output is enabled
	**/
	public static void setTerminalOutput(boolean outputToTerminal){
		terminal = outputToTerminal;
		return;
	}

	/***
		Only to be used by the testing API.
		This method prints logging information, if enabled
		If the StackTraceElement is null, it will assume that the method being tested is the method that called this function
		@param location Information about the method being tested
		@param message Information about the test
		@param hadError Whether the test succeeded
	**/
	public static void log(StackTraceElement location, String message, boolean hadError) {
		if(disabled) return;
		/*
			If no information is provided about where the test occurred, assume that the test occred in the method
			that called this method.
		*/
		if(location==null){
			StackTraceElement[] stack = Thread.currentThread().getStackTrace();
			location = stack[stack.length-1];
		}
		String fileName = last.getFileName();
		String className = last.getClassName();
		int lineNumber = last.getLineNumber();
		String methodName = last.getMethodName();
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yy hh:mm:ssa");
		/** Get current time, as formatted above*/
    	String time = sdfDate.format(new Date());
    	if(output!=null){
			output.printf("%s: %s in method '%s' in class '%s' in file '%s' on line %d with message '%s'\n",
				time, hadError?"ERROR  ":"Success", methodName, className, fileName, lineNumber, message);
			output.flush();
		}
		System.err.printf("%s: %s in method '%s' in class '%s' in file '%s' on line %d with message '%s'\n",
			time, hadError?"ERROR  ":"Success", methodName, className, fileName, lineNumber, message);
		System.err.flush();
		return; 
	}
}
