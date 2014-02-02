package com.idt.contest.highschool.winter2014.codetotest;

import com.idt.contest.highschool.winter2014.framework.FrameworkConstants;
import com.idt.contest.highschool.winter2014.*;
//import static com.idt.contest.highschool.winter2014.BuiltinTester;
/**
 * Class containing byte related utility methods
 */
public class ByteUtility {

	/**
	 * Method to translate a byte to a binary string
	 * This algorithm returns the 2's compliment for negative bytes
	 * @param b - byte to translate to binary string (e.g. 57)
	 * @return - String binary representation of byte, 2's compliment if the byte is negative
	 */
	public String byteToBinytaryString(byte b) {
		
		Expectation<String> zeroCase = BuiltinTester.expectEquals(b,(byte)0, "0");
		final byte fin=b;
		Expectation<String> greaterThanZero = BuiltinTester.expect(b, Builder.isGreater((byte)0), new Function<String>(){
			public boolean test(String s){
				return Byte.parseByte(s,2)==fin;
			}
		}, "Failed when greater than zero");
		Expectation<String> lessThanZero = BuiltinTester.expect(b, Builder.isLess((byte)0), new Function<String>(){
			public boolean test(String s){
				return Byte.parseByte(s,2)==255-fin;
			}
		}, "Failed when less than zero");

		//there is a corresponding verify method by every return (although only needed where b could be 0)

		byte remainder = 0;
		byte number = b;
		String binaryRepresentation = "";
		
		// handle the case of zero 
		if (b == 0) {
			//assume b==0, which it should
			BuiltinTester.customAssert(b, Builder.doesEqual((byte)0));
			BuiltinTester.assertEquals(b, (byte)0);
			//
			//
			//
			//
			//
			//
			// BUG below... the wrong value is being returned for zero.
			// Instead of returning FrameworkConstants.ONE_STRING,
			// the code should return FrameworkConstants.ZERO_STRING.
			//
			//
			//
			//
			//
			//
			return lessThanZero.verify(greaterThanZero.verify(zeroCase.verify(FrameworkConstants.ONE_STRING)));
		}
		
		// number is greater than zero 
		while (number != 0) {	
			remainder = (byte) (number % 2);
			number = (byte) (number / 2); 
			
			// add a binary digit to the binary string representation
			if (remainder == 0) {
				// if we have a zero, add a zero to the front of the builder string
				binaryRepresentation = FrameworkConstants.ZERO_STRING + binaryRepresentation;
			} else {
				// if we have any value other than zero, add a one to the front of the builder string
				binaryRepresentation = FrameworkConstants.ONE_STRING + binaryRepresentation;
			}		
		}
		
		// handle negative sign by returning the 2's compliment
		if (b < 0) {
			StringUtility su = new StringUtility();
			binaryRepresentation = su.binaryByteTwosCompliment(binaryRepresentation);
		}
		
		return lessThanZero.verify(greaterThanZero.verify(zeroCase.verify(binaryRepresentation)));
	}
	
	
	/**
	 * Method to shift a byte by a number of bits, 
	 * right shifting is done using the signed right shift operator
	 * @param b - byte to shift
	 * @param placesToShift - number of bits to shift
	 * @param left - boolean, if true shift left, if false shift right
	 * @return - byte after shifting number of bit, 
	 * 			 	 if placesToShift is greater than 8 or negative, return 0
	 */
	public byte shiftByte(byte b, int placesToShift, boolean left) {
		final byte fin = b;
		final int fin2=placesToShift;
		Expectation<Byte> leftCheck = BuiltinTester.expect(left,Builder.doesEqual(true), new Function<Byte>(){
			public boolean test(Byte b){
				return b==fin<<fin2;
			}
		}, "Failed left shift");
		byte shiftedByte;
		
		if (placesToShift > FrameworkConstants.BITS_IN_BYTE || placesToShift < 0) {
			shiftedByte = 0;
		} else if (left) {
			shiftedByte = (byte) (b << placesToShift);
		} else {
			shiftedByte = (byte) (b >> placesToShift);
		}
		
		return leftCheck.verify(shiftedByte);
	}
	
	
}
