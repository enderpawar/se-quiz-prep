package prep;

import static mini.Assertions.assertArrayEquals;
import static mini.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mini.Test;

public class CollectionOpsTest {

    @Test
    void test1_charFrequency() {
        assertEquals(Map.of('b', 1, 'a', 3, 'n', 2), CollectionOps.charFrequency("banana"));
        assertEquals(Map.of(), CollectionOps.charFrequency(""));
        assertEquals(Map.of('x', 1), CollectionOps.charFrequency("x"));
    }

    @Test
    void test2_dedupSorted() {
        assertEquals(List.of(1, 2, 5), CollectionOps.dedupSorted(new int[]{5, 1, 2, 1, 5}));
        assertEquals(List.of(), CollectionOps.dedupSorted(new int[]{}));
        assertEquals(List.of(-3, 0, 7), CollectionOps.dedupSorted(new int[]{7, 0, -3, 7}));
    }

    @Test
    void test3_sortByLengthThenAlpha() {
        assertEquals(
                List.of("cc", "aaa", "bbb"),
                CollectionOps.sortByLengthThenAlpha(List.of("bbb", "cc", "aaa")));
        assertEquals(List.of(), CollectionOps.sortByLengthThenAlpha(List.of()));

        // 원본이 바뀌면 안 된다
        List<String> original = new ArrayList<>(Arrays.asList("bbb", "cc", "aaa"));
        CollectionOps.sortByLengthThenAlpha(original);
        assertEquals(List.of("bbb", "cc", "aaa"), original, "원본 리스트가 변경되었다");
    }

    @Test
    void test4_topK() {
        assertArrayEquals(new int[]{9, 5}, CollectionOps.topK(new int[]{5, 1, 9, 3}, 2));
        assertArrayEquals(new int[]{9, 5, 3, 1}, CollectionOps.topK(new int[]{5, 1, 9, 3}, 10));
        assertArrayEquals(new int[]{}, CollectionOps.topK(new int[]{5, 1}, 0));
        assertArrayEquals(new int[]{7, 7}, CollectionOps.topK(new int[]{7, 2, 7}, 2));
    }

    @Test
    void test5_rotateLeft() {
        assertEquals(List.of(3, 4, 5, 1, 2), CollectionOps.rotateLeft(List.of(1, 2, 3, 4, 5), 2));
        assertEquals(List.of(1, 2, 3), CollectionOps.rotateLeft(List.of(1, 2, 3), 0));
        assertEquals(List.of(2, 3, 1), CollectionOps.rotateLeft(List.of(1, 2, 3), 7));
        assertEquals(List.of(), CollectionOps.rotateLeft(List.of(), 3));
    }
}
