package com.java.dsa.q5.movenegativeelementoneside;

public class MoveNegativeElementOneside {
	public static void getMoveNegativeElementOneside(int[] array) {
		if (array != null && array.length > 0) {
			int high = array.length - 1;
			int low = 0;
			while (low < high) {
				if (array[low] < 0 && array[high] < 0) {
					low++;
				} else if (array[low] >= 0 && array[high] < 0) {
					array[low] = array[low] + array[high];
					array[high] = array[low] - array[high];
					array[low] = array[low] - array[high];
					low++;
				} else {
					high--;
				}
			}
		}
	}

	public static void display(int[] array) {
		if (array != null && array.length > 0) {
			for (int count = 0; count < array.length; count++) {
				System.out.print(array[count] + " ");
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		int[] array = { 0, 5, -4, -8, 2, -7, 9, -8, 55, -10 };
		display(array);
		getMoveNegativeElementOneside(array);
		display(array);
	}
}
