package programs;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter base:");
		int base = scanner.nextInt();

		System.out.println("Enter height:");
		int height = scanner.nextInt();

		System.out.println("Area is: " + (base * height * .5));
		scanner.close();
	}

}
