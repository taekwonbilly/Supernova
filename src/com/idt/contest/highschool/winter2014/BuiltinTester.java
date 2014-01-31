public class BuiltinTester {
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

	public static <A> void customAssert(A a, Function<A> f){
		customAssert(a, f, "DefaultErrorMessage");
	}

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

	public static <A,B> void dualAssert(A a, B b, Function<A> f1, Function<B> f2){
		dualAssert(a, b, f1, f2, "DefaultErrorMessage");
	}

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

	public static <A,B> void dualAssert(A a, B b, BinaryFunction<A,B> bf){
		dualAssert(a, b, bf, "DefaultErrorMessage");
	}

	public static <A> void assertEquals(A a1, A a2, String errorMessage){
		// do stuff (needs Builder)
		return;
	}

	public static <A> void assertEquals(A a1, A a2){
		assertEquals(a1, a2, "DefaultErrorMessage");
	}
}
