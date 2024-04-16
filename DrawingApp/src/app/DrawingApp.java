package app;

import java.util.Random;

public class DrawingApp {
	/*
	 * For every method remove the line with "throw ..." and implement the method.
	 * We are using "throw..." so your code does not display any compilation errors
	 * when you import the zip file. Also, if you don't implement a method you will
	 * see a white square (instead of green) in the submit server
	 */
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		if (maxRows < 1 || maxCols < 1) {
			return null;
		}
		String answer = "";
		for (int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				answer = answer + symbol;
			}
			if (row < maxRows - 1) {
				answer += "\n";
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.print(DrawingApp.getRectangle(6, 9, '*'));
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String answer = "";
		int barSize = maxCols / bars, colorCheck = 0;

		if (barSize < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		}
		for (int i = 1; i <= maxRows; i++) {
			for (int j = 1; j <= bars; j++) {
				colorCheck = j % 3;
				if ((colorCheck) == 1) {
					answer = answer + getVerticalBar(barSize, color1);
				} else if (colorCheck == 2) {
					answer = answer + getVerticalBar(barSize, color2);
				} else if (colorCheck == 0) {
					answer = answer + getVerticalBar(barSize, color3);
				}

			}
			if (i != maxRows) {
				answer = answer + "\n";
			}
		}
		return answer;
	}

	private static String getVerticalBar(int maxCols, char color) {
		String verticalBar = "";
		for (int i = 1; i <= maxCols; i++) { // outer loop rows
			verticalBar = verticalBar + color;
		}
		return verticalBar;
	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		int horizontalBarSize = maxRows / bars, colorCheck = 0;
		String answer = "";

		if (horizontalBarSize < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		}
		for (int i = 1; i <= bars; i++) {
			colorCheck = i % 3;
			if (colorCheck == 1) {
				answer = answer + getHorizontalBar(maxCols, color1, horizontalBarSize, i == bars);
			} else if (colorCheck == 2) {
				answer = answer + getHorizontalBar(maxCols, color2, horizontalBarSize, i == bars);
			} else if (colorCheck == 0) {
				answer = answer + getHorizontalBar(maxCols, color3, horizontalBarSize, i == bars);
			}
		}
		return answer;
	}

	private static String getHorizontalBar(int maxCols, char color, int maxRows, boolean skipLine) {
		String horizontalBar = "";
		for (int i = 1; i <= maxRows; i++) {
			for (int j = 1; j <= maxCols; j++) {
				horizontalBar = horizontalBar + color;
			}
			if (skipLine && i == maxRows) {
				horizontalBar = horizontalBar;
			} else {
				horizontalBar = horizontalBar + "\n";
			}
		}
		return horizontalBar;
	}

	public static String getFlag(int size, char color1, char color2, char color3) {
		String answer = "";
		int colSize = size * 5;
		int counter = size;

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= i; j++) {

				answer = answer + color1;

			}
			for (int k = i; k < colSize; k++) {
				if (i == 1 || i == size) {
					answer = answer + color2;
				} else {
					answer = answer + color3;
				}
			}
			answer += "\n";
		}
		for (int i = 1; i <= size; i++) {
			for (int j = i; j <= size; j++) {

				answer = answer + color1;
			}
			for (int k = counter; k < colSize; k++) {
				if (i == 1 || i == size) {
					answer = answer + color2;
				} else {
					answer = answer + color3;
				}
			}
			counter--;
			if (i < size) {
				answer += "\n";
			}

		}
		return answer;

	}

	public static char getRandomColor(Random random) {
		int randomNumber = random.nextInt(6);
		char color = '\0';
		if (randomNumber == 0) {
			color = 'R';
		} else if (randomNumber == 1) {
			color = 'G';
		} else if (randomNumber == 2) {
			color = 'B';
		} else if (randomNumber == 3) {
			color = 'Y';
		} else if (randomNumber == 4) {
			color = '*';
		} else if (randomNumber == 5) {
			color = '.';
		}
		return color;
	}

	private static boolean isValidColor(char color) {

		if (color == 'R' || color == 'G' || color == 'B' || color == 'Y' || color == '*' /* Black */
				|| color == '.' /* White */) {
			return true;
		} else {
			return false;
		}
	}
}