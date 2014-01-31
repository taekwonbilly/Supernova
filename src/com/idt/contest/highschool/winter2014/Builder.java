public class Builder {
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

	public static Function<Object> isNull(){
		return new Function<Object>(){
			public boolean test(Object a){
				return a == null;
			}
		};
	}

	public static Function<Object> isNotNull(){
		return new Function<Object>(){
			public boolean test(Object a){
				return a != null;
			}
		};
	}

	public static Function<Comparable<Object>> equals(Comparable<Object> t){
		final Comparable<Object> b = t;
		return new Function<Comparable<Object>>(){
			public boolean test(Comparable<Object> a){
				return a.equals(b);
			}
		};
	}
	
	public static Function<Comparable<Object>> isGreater(Comparable<Object> t){
		final Comparable<Object> b = t;
		return new Function<Comparable<Object>>(){
			public boolean test(Comparable<Object> a){
				return (a.compareTo(b) > 0); // Strictly greater
			}
		};
	}
}
