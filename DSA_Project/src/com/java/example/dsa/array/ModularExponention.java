package com.java.example.dsa.array;

public class ModularExponention {

	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		int p = 13;

		int mod = power(x, y, p);
		System.out.println(mod);

	}

	public static int power(int x, int y, int p) {
		int res = 1;
		while (y > 0) {
			if ((y & 1) != 0)
				res = res * x;
			y = y >> 1;
			x = x * x;
		}
		return res % p;
	}

}
