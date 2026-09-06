package prep;

import java.util.Arrays;

public class ArrayOps {

    public static int maxOf(int[] arr) {
        int best = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > best) {
                best = x;
            }
        }
        return best;
    }

    public static int[] reversed(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static int[] sortedCopy(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    public static int sumOfGrid(int[][] grid) {
        int sum = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                sum += grid[r][c];
            }
        }
        return sum;
    }

    public static int[] filled(int n, int value) {
        int[] result = new int[n];
        Arrays.fill(result, value);
        return result;
    }
}
