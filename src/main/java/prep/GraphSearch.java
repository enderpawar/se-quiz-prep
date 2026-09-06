package prep;

import java.util.List;

/**
 * [B4] 그래프 BFS / DFS.
 *
 * 시험에 나오는 개념
 *   - 인접 리스트: 공간 O(V + E), 전체 순회 O(V + E)   ← 보통 이걸 쓴다
 *   - 인접 행렬  : 공간 O(V²),    전체 순회 O(V²)
 *   - BFS 는 큐, DFS 는 스택(또는 재귀)
 *   - 가중치 없는 그래프의 최단 경로는 BFS 로 구한다
 *   - 트리는 "사이클 없는 연결 그래프"이고, 노드 n 개면 간선은 n - 1 개
 *
 * 파이썬에서 adj = [[] for _ in range(n)] 하던 것을 자바로 옮기면:
 *     List<List<Integer>> adj = new ArrayList<>();
 *     for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
 *
 * ★ new ArrayList<>(Collections.nCopies(n, new ArrayList<>())) 는 함정이다.
 *   같은 리스트 하나를 n 번 가리키게 된다. 파이썬의 [[]] * n 과 똑같은 실수다.
 */
public class GraphSearch {

    /**
     * 무방향 그래프의 인접 리스트를 만든다. 정점은 0 부터 n-1.
     * 각 정점의 이웃 목록은 오름차순으로 정렬해서 돌려준다. (결과를 예측 가능하게 하기 위함)
     *
     * edges 의 각 원소는 {u, v} 형태다.
     */
    public static List<List<Integer>> buildAdjacency(int n, int[][] edges) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * start 에서 시작한 BFS 방문 순서.
     * 이웃은 인접 리스트에 담긴 순서대로 살펴본다.
     *
     * 관용구
     *     boolean[] visited = new boolean[n];
     *     Queue<Integer> queue = new ArrayDeque<>();
     *     queue.add(start);  visited[start] = true;      // ★ 넣을 때 표시한다
     *     while (!queue.isEmpty()) { ... }
     *
     * 큐에서 꺼낼 때 표시하면 같은 노드가 큐에 여러 번 들어간다. 넣을 때 표시할 것.
     */
    public static List<Integer> bfs(List<List<Integer>> adj, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * start 에서 시작한 DFS 방문 순서. 재귀로 짜면 된다.
     * 이웃은 인접 리스트에 담긴 순서대로 살펴본다.
     */
    public static List<Integer> dfs(List<List<Integer>> adj, int start) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 연결 요소(connected component)의 개수.
     * 아직 방문하지 않은 정점마다 탐색을 새로 시작한 횟수를 세면 된다.
     */
    public static int countComponents(int n, int[][] edges) {
        throw new UnsupportedOperationException("TODO");
    }
}
