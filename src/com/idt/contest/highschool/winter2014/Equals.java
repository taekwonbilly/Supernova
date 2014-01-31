public class Equals<A> implements Function<A>{
	A toTest;
	public Equals(A a){
		this.toTest = a;
	}
	public boolean test(A a){
		return this.toTest.equals(a);
	}
}
