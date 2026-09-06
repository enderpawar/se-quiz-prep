package prep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class GraphSearch {

    public static List<List<Integer>> buildAdjacency(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());       // ★ 반드시 매번 새 리스트를 만들 것
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);          // 무방향이므로 양쪽에 넣는다
        }
        for (List<Integer> neighbors : adj) {
            Collections.sort(neighbors);
        }
        return adj;
    }

    public static List<Integer> bfs(List<List<Integer>> adj, int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = true;                // ★ 큐에 넣을 때 표시한다

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int next : adj.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return order;
    }

    public static List<Integer> dfs(List<List<Integer>> adj, int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfs(adj, start, visited, order);
        return order;
    }

    private static void dfs(List<List<Integer>> adj, int node, boolean[] visited,
            List<Integer> order) {
        visited[node] = true;
        order.add(node);
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs(adj, next, visited, order);
            }
        }
    }

    public static int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = buildAdjacency(n, edges);
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;                 // 탐색을 새로 시작한 횟수 = 덩어리 개수
                markComponent(adj, i, visited);
            }
        }
        return components;
    }

    private static void markComponent(List<List<Integer>> adj, int start, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : adj.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
