package system;

public class TwoDimArrayUtil {

    public static char[][] appendLeftRight(char[][] left, char[][] right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Null Array");
        }

        int maxRows = Math.max(left.length, right.length);
        char[][] newArray = new char[maxRows][];

        for (int row = 0; row < maxRows; row++) {
            int leftRowLength = row < left.length ? left[row].length : 0;
            int rightRowLength = row < right.length ? right[row].length : 0;

            newArray[row] = new char[leftRowLength + rightRowLength];
            if (row < left.length) {
                System.arraycopy(left[row], 0, newArray[row], 0, leftRowLength);
            }
            if (row < right.length) {
                System.arraycopy(right[row], 0, newArray[row], leftRowLength, rightRowLength);
            }
        }

        return newArray;
    }

    public static char[][] appendTopBottom(char[][] top, char[][] bottom) {
        int totalRows = top.length + bottom.length;
        char[][] result = new char[totalRows][];

        for (int i = 0; i < top.length; i++) {
            result[i] = new char[top[i].length];
            System.arraycopy(top[i], 0, result[i], 0, top[i].length);
        }

        for (int i = 0; i < bottom.length; i++) {
            result[i + top.length] = new char[bottom[i].length];
            System.arraycopy(bottom[i], 0, result[i + top.length], 0, bottom[i].length);
        }

        return result;
    }

    public static boolean isRagged(char[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        for (int row = 0; row < array.length - 1; row++) {
            if (array[row] == null || array[row + 1] == null || array[row].length != array[row + 1].length) {
                return true;
            }
        }

        return false;
    }

    public static void rotateLeftOneColumn(char[][] array) {
        if (array == null || array.length == 0 || isRagged(array)) {
            throw new IllegalArgumentException("Null, Empty or Ragged Array");
        }

        if (array[0].length <= 1) {
            return;
        }

        for (char[] row : array) {
            char first = row[0];
            System.arraycopy(row, 1, row, 0, row.length - 1);
            row[row.length - 1] = first;
        }
    }

    public static void rotateTopOneRow(char[][] array) {
        if (array == null || array.length <= 1 || isRagged(array)) {
            throw new IllegalArgumentException("Null, Single-rowed, or Ragged Array");
        }

        char[] first = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = first;
    }
}
