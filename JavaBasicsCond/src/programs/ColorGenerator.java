package programs;

import java.util.Scanner;

public class ColorGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Do you want red? (Yes/Yeah/No): ");
		String redResponse = scanner.next();
		String redcolor = "";

		if (redResponse.equals("Yes")) {
			redcolor = "FF";
		}
		if (redResponse.equals("Yeah")) {
			redcolor = "FF";
		} else if (redResponse.equals("No")) {
			redcolor = "00";
		}

		System.out.print("Do you want green and blue? (Yes/Yeah/No): ");
		String greenResponse = scanner.next();
		String greencolor = "";

		if (greenResponse.equals("Yes")) {
			greencolor = "FFFF";
		}
		if (greenResponse.equals("Yeah")) {
			greencolor = "FFFF";
		} else if (greenResponse.equals("No")) {
			greencolor = "0000";
		}

		System.out.println("Final Color: " + "#" + redcolor + greencolor);
		scanner.close();
	}
}
