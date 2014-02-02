package com.idt.contest.highschool.winter2014;

import com.idt.contest.highschool.winter2014.Function;
/** 
 * Handy prebuilt Functions ready to be used with BuiltinTester.
 */
public class Builder {

	/**
	 * Returns a Function to test if an array of integers is in order.
	 * @param An array of integers.
	 * @return Function to test if an array is in order.
	 */
	public static Function inOrder(int[] a){
		return new Function<int[]>(){
			public boolean test(int[] t){
				if(t.length > 1)
					for(int i = 0; i < t.length - 1; i++)
						if(t[i] > t[i+1])
							return false;
				return true;
			}
		};
	}
	
	/**
	 * Returns a Function to test if an array of doubles is in order.
	 * @param An array of doubles.
	 * @return Function to test if an array is in order.
	 */
	public static Function inOrder(double[] a){
		return new Function<double[]>(){
			public boolean test(double[] t){
				if(t.length > 1)
					for(int i = 0; i < t.length - 1; i++)
						if(t[i] > t[i+1])
							return false;
				return true;
			}
		};
	}
	
	/**
	 * Returns a Function to test if an array of Comparables is in order.
	 * @param An array of Comparables.
	 * @return Function to test if an array is in order.
	 */
	public static Function<Comparable<Object>[]> inOrder(Comparable<Object>[] a){
		return new Function<Comparable<Object>[]>(){
			public boolean test(Comparable<Object>[] t){
				if(t.length > 1)
					for(int i = 0; i < t.length - 1; i++)
						if(t[i].compareTo(t[i+1]) < 0)
							return false;
				return true;
			}
		};
	}

	/**
	 * Returns a Function to test if an Object is null.
	 * @return Function to test if an Object is null.
	 */
	public static Function<Object> isNull(){
		return new Function<Object>(){
			public boolean test(Object a){
				return a == null;
			}
		};
	}

	/**
	 * Returns a Function to test if an Object is not null.
	 * @return Function to test if an Object is not null.
	 */
	public static Function<Object> isNotNull(){
		return new Function<Object>(){
			public boolean test(Object a){
				return a != null;
			}
		};
	}

	/**
	 * Returns a Function to test if an Object equals another object.
	 * @param t An object to be compared to.
	 * @return Function to test if an Object is equal to t.
	 */
	public static Function<Comparable<Object>> equals(Comparable<Object> t){
		final Comparable<Object> b = t;
		return new Function<Comparable<Object>>(){
			public boolean test(Comparable<Object> a){
				return a.equals(b);
			}
		};
	}
	
	/**
	 * Returns a Function to test if an Object is strictly greater than another object.
	 * @param t An object to be compared to.
	 * @return Function to test if an Object is strictly to t.
	 */
	public static Function<Comparable<Object>> isGreater(Comparable<Object> t){
		final Comparable<Object> b = t;
		return new Function<Comparable<Object>>(){
			public boolean test(Comparable<Object> a){
				return (a.compareTo(b) > 0); // Strictly greater
			}
		};
	}
}
