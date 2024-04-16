package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysImplementation.Utilities;

public class StudentTests {

	@Test
	public void getInstancesTest() {
		int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int lowerLimit = 3;
		int upperLimit = 7;

		int result = Utilities.getInstances(testArray, lowerLimit, upperLimit);

		int expected = 5;

		assertEquals(expected, result);
	}

	@Test
	public void filterTest() {
		int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int lowerLimit = 3;
		int upperLimit = 7;

		int[] result = Utilities.filter(testArray, lowerLimit, upperLimit);

		int[] expected = { 3, 4, 5, 6, 7 };

		assertArrayEquals(expected, result);
	}

	@Test
	public void getArrayStringTest() {
		int[] testArray = { 1, 2, 3, 4, 5 };
		char testSeparator = '$';

		String result = Utilities.getArrayString(testArray, testSeparator);

		String expected = "1$2$3$4$5";

		assertEquals(expected, result);
	}

	@Test
	public void filter() {
		int[] array = { 5, 7, 8, 10, 20 };
		int lowerLimit = 4;
		int upperLimit = 9;
		int[] expectedOutput = { 5, 7, 8 };
		int[] actualOutput = Utilities.filter(array, lowerLimit, upperLimit);

		assertArrayEquals(expectedOutput, actualOutput);
	}

	@Test
	public void rotate() {
		int[] array = { 10, 20, 7, 8 };
		int[] expectedOutput = { 7, 8, 10, 20 };
		Utilities.rotate(array, true, 2);

		assertArrayEquals(expectedOutput, array);
	}

	
}
