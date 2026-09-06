package prep;

import java.util.ArrayDeque;
import java.util.Queue;

public class GridBfs {

    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   // 상 하 좌 우

    public static int shortestPath(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});        // {행, 열, 지나온 칸 수}
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (r == rows - 1 && c == cols - 1) {
                return dist;                  // BFS 라서 처음 도착한 순간이 곧 최단이다
            }

            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                if (grid[nr][nc] == 1 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, dist + 1});
            }
        }
        return -1;
    }

    public static int countIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    islands++;
                    sink(grid, visited, r, c);
                }
            }
        }
        return islands;
    }

    /** 붙어 있는 땅을 전부 방문 표시한다. 원본 grid 는 건드리지 않는다. */
    private static void sink(char[][] grid, boolean[][] visited, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : DIR) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                if (grid[nr][nc] != '1' || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}
