package prep;

import static mini.Assertions.assertArrayEquals;
import static mini.Assertions.assertEquals;

import mini.Test;

public class ArrayOpsTest {

    @Test
    void test1_maxOf() {
        assertEquals(9, ArrayOps.maxOf(new int[]{3, 9, 2}));
        assertEquals(-2, ArrayOps.maxOf(new int[]{-7, -2, -5}));
        assertEquals(4, ArrayOps.maxOf(new int[]{4}));
        assertEquals(Integer.MIN_VALUE, ArrayOps.maxOf(new int[]{}));
    }

    @Test
    void test2_reversed() {
        assertArrayEquals(new int[]{3, 2, 1}, ArrayOps.reversed(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{}, ArrayOps.reversed(new int[]{}));

        // 원본이 바뀌면 안 된다
        int[] original = {1, 2, 3, 4};
        ArrayOps.reversed(original);
        assertArrayEquals(new int[]{1, 2, 3, 4}, original, "원본 배열이 변경되었다");
    }

    @Test
    void test3_sortedCopy() {
        assertArrayEquals(new int[]{1, 2, 5, 8}, ArrayOps.sortedCopy(new int[]{5, 2, 8, 1}));

        int[] original = {5, 2, 8, 1};
        ArrayOps.sortedCopy(original);
        assertArrayEquals(new int[]{5, 2, 8, 1}, original, "원본 배열이 변경되었다");
    }

    @Test
    void test4_sumOfGrid() {
        assertEquals(21, ArrayOps.sumOfGrid(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        assertEquals(0, ArrayOps.sumOfGrid(new int[][]{{0, 0}, {0, 0}}));
        assertEquals(7, ArrayOps.sumOfGrid(new int[][]{{7}}));
    }

    @Test
    void test5_filled() {
        assertArrayEquals(new int[]{9, 9, 9}, ArrayOps.filled(3, 9));
        assertArrayEquals(new int[]{0, 0}, ArrayOps.filled(2, 0));
        assertArrayEquals(new int[]{}, ArrayOps.filled(0, 5));
    }
}
