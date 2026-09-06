package prep;

import static mini.Assertions.assertEquals;

import mini.Test;

public class GridBfsTest {

    @Test
    void test1_shortestPathSimple() {
        // 0 0 0
        // 1 1 0
        // 0 0 0     → (0,0)(0,1)(0,2)(1,2)(2,2) = 5 칸
        assertEquals(5, GridBfs.shortestPath(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}}));

        assertEquals(1, GridBfs.shortestPath(new int[][]{{0}}));
        assertEquals(3, GridBfs.shortestPath(new int[][]{{0, 0, 0}}));
    }

    @Test
    void test2_shortestPathBlocked() {
        // 0 1
        // 1 0     → 갈 수 없다
        assertEquals(-1, GridBfs.shortestPath(new int[][]{
                {0, 1},
                {1, 0}}));

        assertEquals(-1, GridBfs.shortestPath(new int[][]{{1}}), "출발 칸이 벽이다");
        assertEquals(-1, GridBfs.shortestPath(new int[][]{{0, 0}, {0, 1}}), "도착 칸이 벽이다");
    }

    @Test
    void test3_shortestPathDetour() {
        // 0 1 0
        // 0 1 0
        // 0 0 0     → 아래로 돌아가야 한다: (0,0)(1,0)(2,0)(2,1)(2,2) = 5 칸
        assertEquals(5, GridBfs.shortestPath(new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}}));
    }

    @Test
    void test4_countIslands() {
        assertEquals(2, GridBfs.countIslands(new char[][]{
                {'1', '1', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}}));

        assertEquals(0, GridBfs.countIslands(new char[][]{
                {'0', '0'},
                {'0', '0'}}));

        assertEquals(1, GridBfs.countIslands(new char[][]{
                {'1', '1'},
                {'1', '1'}}));

        // 대각선으로만 붙은 것은 같은 섬이 아니다
        assertEquals(3, GridBfs.countIslands(new char[][]{
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'0', '0', '0'}}));
    }
}
