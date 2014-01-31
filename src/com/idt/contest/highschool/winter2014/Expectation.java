public class Expectation<A> {
	boolean initCondition;
	Function<A> finalCondition;

	public Expectation(boolean init, Function<a> fin){
		this.initCondition = init;
		this.finalCondition = fin;
	}

	public A verify(A a){
		if(this.initCondition){
			if(this.finalCondition.test(a)){
				// log correct
			}
			else {
				// log something went wrong
			}
		}
		return a;
	}
}
