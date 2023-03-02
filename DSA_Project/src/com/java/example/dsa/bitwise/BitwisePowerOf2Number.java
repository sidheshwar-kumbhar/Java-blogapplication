package com.java.example.dsa.bitwise;

//Java code for Compute modulus division by a power-of-2-number
// Compute n modulo d without division(/) and modulo(%) operators, where d is a power of 2 number. 

public class BitwisePowerOf2Number {
	// This function will return n % d.
	// d must be one of: 1, 2, 4, 8, 16, 32,
	static int getModulo(int n, int d) {
		return (n & (d - 1));
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 6;

		/* d must be a power of 2 */
		int d = 4;

		System.out.println(n + " % " + d + " = " + getModulo(n, d));
	}
}

/*
n = 6 and d = 4.
The binary value of  6 = 0110  and 4 = 0010
d must be a power of 2 : 1, 2, 4, 8, 16, 32
n & (d - 1)
6 & (4 - 1) = 6 & (4 - 1) = 6 & 3
= 0110 & (0100 - 0001)
= 0110 & 0011 (binary values)
= 0010  (binary value)
= 2 Decimal value

Ans : 6 % 4 = 2

6 & (4 - 1) = 6 & (4 - 1) = 6 & 3
= 0110 & 0011 (binary values)
= 0010  (binary value)
= 2 Decimal value


NOTE: The power of 2 modulo reminder will be 2 or 0 means 2nd bits should be 1 or 0 and first bit always 0 because of d is power of 2

We can use the expression n & (d-1) to compute the value of the expression n % d when n and d are both positive and d is a power of 2.

How this works?

The expression d-1 has all the bits flipped (0 to 1) after the set bit of d (which is also flipped from 1 to 0), i.e.,

00001000                        (d = 8)
00000111                        (d-1 = 7)
So, the expression n & (d-1) converts all left bits of n starting from the i'th bit to 0 and leave bits from 0 to i-1 as it is. 
Here, i is the position of the only set bit in d. For example,

00010010        &               (n = 18)
00000111                        (d-1 = 7)
~~~~~~~~
00000010                        (n % d)


*/
