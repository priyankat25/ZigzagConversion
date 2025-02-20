package com.kodnest.zigzagconv;

import java.util.Scanner;

public class ZigzagConversion {
	public static String convertToZigzag(String s, int numRows) {
		if (numRows == 1 || s.length() <= numRows) {
			return s;
		}

		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			rows[i] = new StringBuilder();
		}

		int currentRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows[currentRow].append(c);

			if (currentRow == 0 || currentRow == numRows - 1) {
				goingDown = !goingDown;
			}

			currentRow += goingDown ? 1 : -1;
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder row : rows) {
			result.append(row);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int numRows = scanner.nextInt();

		scanner.close();

		String zigzag = convertToZigzag(input, numRows);
		System.out.println("Zigzag converted string: " + zigzag);
	}
}