package com.java.example.dsa.array;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1, }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		print(image);
		System.out.println("");
		image = getFloodFillImage(image, sr, sc, color);
		print(image);
	}

	public static void print(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static int[][] getFloodFillImage(int[][] image, int sr, int sc, int color) {
		if (image != null && image.length > 0) {
			if (sr > 0 && sr < image.length && sc > 0 && sc < image[0].length) {
				int val = image[sr - 1][sc - 1];
				for (int i = sr - 1; i < image.length; i++) {
					for (int j = sc - 1; j < image[i].length; j++) {
						if (image[i][j] == val) {
							image[i][j] = color;
						} else {
							break;
						}
					}
				}
			}
		}
		return image;
	}

}
