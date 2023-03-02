package com.java.example.dsa.easy;

public class Update0To5 {
	public static void main(String[] args) {
		int number = 1005;
		System.out.println(number);
		System.out.println(getUpdate0To5(number));
	}

	public static int getUpdate0To5(int number) {
		int tmpNumber = 0;
		int power = 0;
		double mul = 0;
		if (number == 0) {
			return 5;
		}

		while (number != 0) {
			int mod = number % 10;
			number = number / 10;
			if (mod == 0) {
				mod = 5;
			}
			mul = Math.pow(10, power);
			tmpNumber += mod * mul;
			power++;
		}
		return tmpNumber;
	}
}