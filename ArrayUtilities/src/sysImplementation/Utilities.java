package sysImplementation;

public class Utilities {
	public static int getInstances(int[] array, int lowerLimit, int upperLimit) {
		int count = 0;
		for (int value : array) {
			if (value >= lowerLimit && value <= upperLimit) {
				count++;
			}
		}
		return count;
	}

	public static int[] filter(int[] array, int lowerLimit, int upperLimit) {
		int length = getInstances(array, lowerLimit, upperLimit);
		int[] filteredArray = new int[length];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (array[i] >= lowerLimit && array[i] <= upperLimit) {
				filteredArray[k++] = array[i];
			}
			if (lowerLimit > upperLimit) {
				throw new IllegalArgumentException("Inavalid ArgumentException: invalid limits");
			}
		}
		return filteredArray;
	}

	public static String getArrayString(int[] array, char separator) {
		StringBuilder arrayString = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			arrayString.append(array[i]);
			if (i < array.length - 1) {
				arrayString.append(separator);
			}
		}
		return arrayString.toString();
	}

	public static StringBuffer[] getArrayStringsLongerThan​(StringBuffer[] array, int length) {
		int count = 0;
		for (StringBuffer sb : array) {
			if (sb != null && sb.length() > length)
				count++;
		}

		StringBuffer[] longerThanArray = new StringBuffer[count];
		int index = 0;

		for (StringBuffer sb : array) {
			if (sb != null && sb.length() > length) {
				longerThanArray[index++] = new StringBuffer(sb.toString());
			}
		}

		return longerThanArray;
	}

	public static void rotate(int[] array, boolean leftRotation, int positions) {
		if (array == null || array.length <= 1) {
			return;
		}

		int length = array.length;

		positions = positions % length;
		if (positions == 0) {
			return;
		}

		if (!leftRotation) {

			positions = length - positions;
		}

		reverse(array, 0, positions - 1);
		reverse(array, positions, length - 1);
		reverse(array, 0, length - 1);
	}

	public static void reverse(int[] array, int start, int end) {
		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
