package com.java.example.dsa.array;

public class RotateArray {

	public static void main(String[] args) {
		int[][] inputArray = { 
				{ 2, 4, 6, 10 }, 
				{ 5, 3, 1, 11 }, 
				{ 8, 7, 9, 12 }, 
				{ 6, 8, 4, 24 } 
			};

		printArray(inputArray);
		rotateArray90(inputArray);
		printArray(inputArray);
	}

	public static void printArray(int[][] inputArray) {
		if (inputArray != null) {
			for (int i = 0; i < inputArray.length; i++) {
				for (int j = 0; j < inputArray[i].length; j++) {
					System.out.print(inputArray[i][j] + ", ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
	}

	public static void rotateArray90(int[][] inputArray) {
		if (inputArray != null && inputArray.length == inputArray[0].length) {
			int size = inputArray.length;
			for (int layear = 0; layear < size / 2; layear++) {
				int first = layear;
				int last = size - 1 - layear;

				for (int i = first; i < last; i++) {
					int offset = i - first;
					int top = inputArray[first][i];
					inputArray[first][i] = inputArray[last - offset][first];
					inputArray[last - offset][first] = inputArray[last][last - offset];
					inputArray[last][last - offset] = inputArray[i][last];
					inputArray[i][last] = top;
				}

			}
		}
	}
}
