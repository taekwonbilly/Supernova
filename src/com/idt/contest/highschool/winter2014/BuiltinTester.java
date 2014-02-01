/**
 * Class that does handles testing. Contains assertions, as well as a way of interfacing with Expectations The following generic methods handles all of the primative types, as in the recent versions of Java the primative types are autoboxed to their wrapper classes (e.g. int to Integer). 
 */
public class BuiltinTester {
				
	/**
	 * Checks if an object passes a particular function. If the function returns true, log that it passed. If not, logged that it failed with a custom error message.
	 *
	 * @param a Any object that needs to be tested.
	 * @param f An object that implements the Function<A> interface. The object is tested with this object's test method.
	 * @param errorMessage Custom error message string in case the test fails.
	 * 
	 */
	public static <A> void customAssert(A a, Function<A> f, String errorMessage){
		if(f.test(a)){
			// log the correct stuff
			return;
		}
		else {
			// log the incorrect stuff
			return;
		}
	}
	
	/**
	 * Checks if an object passes a particular function. If the function returns true, log that it passed. If not, logged that it failed with the default error message.
	 *
	 * @param a Any object that needs to be tested.
	 * @param f A n object that implements the Function<A> interface. The object is tested against this object's test method.
	 *
	 */ 
	public static <A> void customAssert(A a, Function<A> f){
		customAssert(a, f, "DefaultErrorMessage");
	}

	/**
	 * Checks if two objects pass two separate functions. If f1 acting on a is true AND f2 acting on b is true, then logs successful. If not, logs that it failed with a custom error message.
	 * @param a Any object that needs to be tested.
	 * @param b A different object that needs to be tested.
	 * @param f1 An object that implements the Function<A> interface. a is tested with this object's test method.
	 * @param f2 An object that implements the Function<A> interface. b is tested with this object's test method.
	 * @param errorMessage Custom error message string in case the test fails. 
	 */
	public static <A,B> void dualAssert(A a, B b, Function<A> f1, Function<B> f2, String errorMessage){
		if(f1.test(a) && f2.test(b)){
			// log the correct stuff
			return;
		}
		else {
			// log the incorrect stuff
			return;
		}
	}

	/**
	 * Checks if two objects pass two separate functions. If f1 acting on a is true AND f2 acting on b is true, then logs success. If not, logs that it failed with a custom error message.
	 * @param a Any object that needs to be tested.
	 * @param b A different object that needs to be tested.
	 * @param f1 An object that implements the Function<A> interface. a is tested with this object's test method.
	 * @param f2 An object that implements the Function<A> interface. b is tested with this object's test method.
	 */
	public static <A,B> void dualAssert(A a, B b, Function<A> f1, Function<B> f2){
		dualAssert(a, b, f1, f2, "DefaultErrorMessage");
	}

	/**
	 * Checks if two objects pass a single function. If bf acting on a and b is true, then logs success. If not, logs that it failed with a custom error message.
	 * @param a Any object that needs to be tested.
	 * @param b A different object that needs to be tested.
	 * @param bf An object that implements the Function<A> interface. Both a and b are tested with this object's test method.
	 * @param errorMessage Custom error message string in case the test fails
	 */
	public static <A,B> void dualAssert(A a, B b, BinaryFunction<A,B> bf, String errorMessage){
		if(bf.test(a, b)){
			// log correct stuff
			return;
		}
		else {
			// log incorrect stuff
			return;
		}
	}	

	/**
	 * Checks if two objects pass a single function. If bf acting on a and b is true, then logs success. If not, logs that it failed with the default error message.
	 * @param a Any object that needs to be tested.
	 * @param b A different object that needs to be tested.
	 * @param bf An object that implements the Function<A> interface. Both a and b are tested with this object's test method.
	 */
	public static <A,B> void dualAssert(A a, B b, BinaryFunction<A,B> bf){
		dualAssert(a, b, bf, "DefaultErrorMessage");
	}

	/**
	 * Checks if both a1 and a2 are equal. If they are, logs success. If not, logs that it failed with a custom error message.
	 * @param a1 Any object that needs to be tested.
	 * @param a2 Another object that should equal a1.
	 * @param errorMessage Custom error message string in case the test fails.
	 */
	public static <A> void assertEquals(A a1, A a2, String errorMessage){
		// do stuff (needs Builder)
		return;
	}

	/**
	 * Checks if both a1 and a2 are equal. If they are, logs success. If not, logs that it failed with the default error message.
	 * @param a1 Any object that needs to be tested.
	 * @param a2 Another object that should equal a1.
	 */
	public static <A> void assertEquals(A a1, A a2){
		assertEquals(a1, a2, "DefaultErrorMessage");
	}

	/**
	 * Creates an Expectation<B> that expects the result of init acting on a, with a testing function of check.
	 * @param a Any object that needs to be tested.
	 * @param init An object that implements the Function<A> interface. The expectation is passed the value of init acting upon a.
	 * @param check The testing function passed to the Expectation that is returned.
	 * @return Returns an Expectation that expects the value of init acting upon a with the testing function check.
	 */
	public static <A,B> Expectation<B> expect(A a, Function<A> init, Function<B> check){
		boolean isValid = init.test(a);
		return new Expectation<B>(isValid, check);
	}

	/**
	 * Creates an Expectation<B> that expects true if a1 and a2 are equal. If not, expects false. And, for the testing function checks to see if b is equal.
	 * @param a1 Any object that needs to be tested.
	 * @param a2 Another object that needs to be tested.
	 * @param b An object whose equality will be expected by the expectation.
	 * /
	public static <A,B> Expectation<B> expectEquals(A a1, A a2, B b){
		return expect(a1, new Equals<A>(a2), new Equals<B>(b));
	}
}
