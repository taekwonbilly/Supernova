import java.io.PrintWriter;
import java.io.File;
public class Logger {
	private static String filename = "default.txt.";
	private static boolean terminal = false;

	public static void setFilename(String s){
		filename = s;
	}

	public static void setTerminalOutput(boolean outputToTerminal){
		terminal = true;
	}

	public static void error(String s) throws Exception{
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StackTraceElement last = stack[stack.length - 1];
		String fileName = last.getFileName();
		String className = last.getClassName();
		int lineNumber = last.getLineNumber();
		String methodName = last.getMethodName();
	
		PrintWriter pw = new PrintWriter(new File(filename));
		// format and output to file
		if(terminal){
			// log terminal
		}
		return; 
	}
	
	public static void log(String s){

	}
}
