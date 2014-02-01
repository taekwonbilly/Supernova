package com.idt.contest.highschool.winter2014;

import java.io.PrintWriter;
import java.io.File;
import java.util.*;
import java.text.*;
public class Logger {
	public static PrintWriter output=null;
	private static boolean terminal = true;
	public static boolean disabled=false;
	public static void setFile(File f){
		if(output!=null){
			output.close();
		}
		try{
			output = new PrintWriter(f);
		}catch(Exception e){
			System.err.println("Could find or create file '"+f+"' for use in logger -- terminating");
			System.exit(1);
		}
		return;
	}
	public static void enable(){
		disabled=false;
	}
	public static void disable(){
		disabled=true;
	}
	public static void setFile(String s){
		setFile(new File(s));
		return;
	}

	public static void setTerminalOutput(boolean outputToTerminal){
		terminal = outputToTerminal;
		return;
	}

	public static void log(String message, boolean hadError) {
		if(disabled) return;
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StackTraceElement last = stack[stack.length - 1];
		String fileName = last.getFileName();
		String className = last.getClassName();
		int lineNumber = last.getLineNumber();
		String methodName = last.getMethodName();
		SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yy hh:mm:ssa");//dd/MM/yyyy
		/** Get current time, as formatted above*/
    	String time = sdfDate.format(new Date());
		output.printf("%s: %s in method '%s' in class '%s' in file '%s' on line %d with message '%s'\n",
			time, hadError?"ERROR  ":"Success", methodName, className, fileName, lineNumber, message);
		output.flush();

		System.err.printf("%s: %s in method '%s' in class '%s' in file '%s' on line %d with message '%s'\n",
			time, hadError?"ERROR  ":"Success", methodName, className, fileName, lineNumber, message);
		System.err.flush();
		return; 
	}
	public static void main(String[] args){
		Logger.setFile("test.txt");
		Logger.log("Fail 1", false);
		Logger.log("Success 1", true);
		return;
	}
}
