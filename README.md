Supernova
=========

IDT 2014 Winter Contest

TJHSST 1 (Billy Moses, Abi Gopal)

## A Very Brief Tutorial
One of the largest sources of loss of productivity for developers is tracking down small bugs that occur during coding. Fortunately, Supernova makes it easy for developers to add robust error checking quickly and easily to their code. In this tutorial, we'll cover the very basics of what Supernova can do.

### Adding Test Cases and using Expectations
Consider the following code to count vowels in code:
<pre><code>
	public int countVowels(String word) {
		int vowelCount = 0;
		char[] vowels = {'a','e','i','o','u','A','E','I','0','U'};
		// insert code to loop through the characters in word and add up all the vowels.
		return vowelCount; 			
	}
</code></pre>
In this example, the capital 'O' is replaced by a '0'. This error might be small, but it could lead to all kinds of errors. In addition, tracking it down, and noticing such a subtle mistake is by no means an easy task. Let's look at a very simple case where Supernova can be used to help developers track down bugs. With Supernova we can write:
<pre><code>
	public int countVowels(String word) {
		int vowelCount = 0;
		Expectation<Integer> e = BuiltinTester.expectsEquals(word, "aeiouAEIOU", 10);
		char[] vowels = {'a','e','i','o','u','A','E','I','0','U'};
		// insert code to loop through the characters in word and add up all the vowels.
		return e.verify(vowelCount);
	}
</code></pre>
By simply adding one line and modifying another, Supernova will immediately log the file name, method name, and line number of the offending bit of code, when this method is ran with <pre><code>word = "aeiouAEIOU"</code>.</pre>, If the method is fed in "aeiouAEIOU" and <pre><code>vowelCount</code> </pre>,isn't 10, then the logger will log an error. If everything is good, and vowelCount is 10 at the time of return, then the logger will indicate that the program successfully made it through that one test case.  A developer could quickly write a list of possible test cases, automate his or her program to run through them, and just check Supernova's log to see if there are any issues. By considering simple cases and edge cases from the start, Supernova allows developers to avoid using ad hoc approaches to error checking.

Expectations can be used for more than just testing equality. The <pre><code>BuiltinTester</code> </pre>,includes a generic "expects" function, which can be passed in a <pre><code>Function</code></pre>, which could then be used to create more test cases. For example, I could have pass "expects" an argument that ensures that for a particular input, my code will return true for a particular function. I could also pass "expects" two <pre><code>Functions</code></pre>, which would make sure that for any input that passes the first Function, the second Function must also be true. This allows for robust inputs for test cases.

## Assertions
Sometimes, we want to ensure that a particular variable meets some kind of rule, at an instance in the code. In essence, we want to "assert" that something is true. Java 7 provides basic assertions to ensure equality, but Supernova takes this one step further. Consider:
<pre><code>
	public void doSomething(int a){
		int b = transform(a);
		// the transform method SHOULD only return an even number.	
		return;
	}
</code></pre>
These cases are fairly common, and it's clear that Java's regular assertion isn't enough to fix this problem. Let's explore how Supernova can fix this issue:
<pre><code>
	public void doSomething(int a){
		int b = transform(a);
		BuiltinTester.customAssert(b, new Function<Integer>{
			public boolean test(int A){
				if(b % 2 == 0)
					return true;
				return false;	
			}
		});
	}
</code></pre>
Voila! Now, if something happens to transform, and transform stops yielding even numbers, Supernova's logger will instantly show that this assertion failed, immediately showing the developer that there is an issue with transform. 

In addition to the above example, Supernova supports multiple types of custom assertions, including binary assertions. Supernova also includes a handy <pre><code>Builder</code></pre> class which comes with several Functions that can be used right from the get go.

## Disabling Supernova
If you have very time/space complex testing code, it may be a good idea to disable Supernova before putting your program into production. This can easily be done by using <pre><code>Logger.disable()</code></pre>.
