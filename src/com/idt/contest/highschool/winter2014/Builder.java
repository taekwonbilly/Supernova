package com.idt.contest.highschool.winter2014;

import com.idt.contest.highschool.winter2014.Function;
/** 
 * Handy prebuilt Functions ready to be used with BuiltinTester.
 */
public class Builder {

	/**
	 * Returns a Function to test if an array of Comparables is in order.
	 * @param An array of Comparables.
	 * @return Function to test if an array is in order.
	 */
	public static <T extends Comparable> Function<T[]> inOrder(T[] a){
		return new Function<T[]>(){
			public boolean test(T[] t){
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
	public static <T> Function<T> doesEqual(T t){
		final T b = t;
		return new Function<T>(){
			public boolean test(T a){
				return a.equals(b);
			}
		};
	}
	
	/**
	 * Returns a Function to test if an Object is strictly greater than another object.
	 * @param t An object to be compared to.
	 * @return Function to test if an Object is strictly to t.
	 */
	public static <T extends Comparable> Function<T> isGreater(T t){
		final T b = t;
		return new Function<T>(){
			public boolean test(T a){
				return (a.compareTo(b) > 0); // Strictly greater
			}
		};
	}

	/**
	 * Returns a Function to test if an Object is strictly less than another object.
	 * @param t An object to be compared to.
	 * @return Function to test if an Object is strictly to t.
	 */
	public static <T extends Comparable> Function<T> isLess(T t){
		final T b = t;
		return new Function<T>(){
			public boolean test(T a){
				return (a.compareTo(b) < 0); // Strictly less
			}
		};
	}

	/**
	 * Returns a Function to test if an Object is greater than or equal to another object.
	 * @param t An object to be compared to.
	 * @return Function to test if an Object is strictly to t.
	 */
	public static <T extends Comparable> Function<T> isGreaterOrEqual(T t){
		final T b = t;
		return new Function<T>(){
			public boolean test(T a){
				return (a.compareTo(b) >= 0); // greater
			}
		};
	}

	/**
	 * Returns a Function to test if an Object is less than or equal to another object.
	 * @param t An object to be compared to.
	 * @return Function to test if an Object is strictly to t.
	 */
	public static <T extends Comparable> Function<T> isLessOrEqual(T t){
		final T b = t;
		return new Function<T>(){
			public boolean test(T a){
				return (a.compareTo(b) <= 0); // less
			}
		};
	}
}
