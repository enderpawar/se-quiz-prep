package prep;

/**
 * [B5] 2차원 격자 탐색. 테트리스 보드도 결국 2차원 배열이라 감각을 익혀 두면 좋다.
 *
 * 4방향 이동 관용구 — 외워 두면 편하다.
 *     int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   // 상 하 좌 우
 *     for (int[] d : DIR) {
 *         int nr = r + d[0];
 *         int nc = c + d[1];
 *         if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;   // 범위 밖
 *         ...
 *     }
 *
 * 큐에 좌표를 넣을 때는 int[] 두 칸짜리를 쓰거나, r * cols + c 로 한 숫자로 눌러 담는다.
 */
public class GridBfs {

    /**
     * 왼쪽 위 (0,0) 에서 오른쪽 아래 (rows-1, cols-1) 까지 가는 최단 경로가
     * 지나는 칸의 개수. 갈 수 없으면 -1.
     *
     * grid 값: 0 = 지나갈 수 있음, 1 = 벽
     * 이동은 상하좌우 4방향.
     * 출발 칸이나 도착 칸이 벽이면 -1.
     * 출발과 도착이 같은 칸이고 벽이 아니면 1.
     *
     * 가중치가 없으니 BFS 를 쓴다. (DFS 로는 최단이 보장되지 않는다)
     */
    public static int shortestPath(int[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 섬의 개수. '1' 이 땅, '0' 이 물이고 상하좌우로 붙어 있으면 같은 섬이다.
     *
     * LeetCode 200. Number of Islands 와 같은 문제.
     * 방문한 땅을 '0' 으로 바꿔 버리면 visited 배열 없이도 풀린다.
     * (단, 그러면 원본 grid 가 망가진다는 점은 알고 있어야 한다)
     */
    public static int countIslands(char[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }
}
