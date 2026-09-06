package prep;

import static mini.Assertions.assertEquals;

import java.util.List;
import mini.Test;

public class GraphSearchTest {

    /**
     *   0 --- 1 --- 3        4 --- 5
     *   |
     *   2
     */
    private static final int[][] EDGES = {{0, 1}, {0, 2}, {1, 3}, {4, 5}};

    @Test
    void test1_buildAdjacency() {
        List<List<Integer>> adj = GraphSearch.buildAdjacency(6, EDGES);
        assertEquals(6, adj.size());
        assertEquals(List.of(1, 2), adj.get(0));
        assertEquals(List.of(0, 3), adj.get(1));
        assertEquals(List.of(0), adj.get(2));
        assertEquals(List.of(1), adj.get(3));
        assertEquals(List.of(5), adj.get(4));
        assertEquals(List.of(4), adj.get(5));
    }

    @Test
    void test2_buildAdjacencyIsolatedVertices() {
        List<List<Integer>> adj = GraphSearch.buildAdjacency(3, new int[][]{});
        assertEquals(3, adj.size());
        assertEquals(List.of(), adj.get(0));
        assertEquals(List.of(), adj.get(1));
        assertEquals(List.of(), adj.get(2));
    }

    @Test
    void test3_bfs() {
        List<List<Integer>> adj = GraphSearch.buildAdjacency(6, EDGES);
        assertEquals(List.of(0, 1, 2, 3), GraphSearch.bfs(adj, 0));
        assertEquals(List.of(1, 0, 3, 2), GraphSearch.bfs(adj, 1));
        assertEquals(List.of(4, 5), GraphSearch.bfs(adj, 4));
    }

    @Test
    void test4_dfs() {
        List<List<Integer>> adj = GraphSearch.buildAdjacency(6, EDGES);
        // 0 → 1 → 3 까지 끝까지 내려간 뒤에 되돌아 나와 2 를 본다
        assertEquals(List.of(0, 1, 3, 2), GraphSearch.dfs(adj, 0));
        assertEquals(List.of(1, 0, 2, 3), GraphSearch.dfs(adj, 1));
        assertEquals(List.of(5, 4), GraphSearch.dfs(adj, 5));
    }

    @Test
    void test5_countComponents() {
        assertEquals(2, GraphSearch.countComponents(6, EDGES));
        assertEquals(3, GraphSearch.countComponents(3, new int[][]{}));
        assertEquals(1, GraphSearch.countComponents(3, new int[][]{{0, 1}, {1, 2}}));
        assertEquals(0, GraphSearch.countComponents(0, new int[][]{}));
    }
}
