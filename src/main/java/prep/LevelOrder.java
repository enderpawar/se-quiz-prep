package prep;

import java.util.List;

/**
 * [B2] BFS 레벨 순회. 트리를 큐로 훑는 방법.
 *
 * 핵심 관용구 — 레벨을 나누고 싶으면 "지금 큐에 들어있는 개수"를 먼저 재 둔다.
 *
 *     Queue<TreeNode> queue = new ArrayDeque<>();
 *     queue.add(root);
 *     while (!queue.isEmpty()) {
 *         int size = queue.size();          // ★ 이 줄이 한 레벨의 크기
 *         for (int i = 0; i < size; i++) {
 *             TreeNode node = queue.poll();
 *             ...
 *             if (node.left != null)  queue.add(node.left);
 *             if (node.right != null) queue.add(node.right);
 *         }
 *     }
 *
 * 파이썬 deque 와 달리 자바 ArrayDeque 에는 null 을 넣을 수 없다.
 * 그래서 add 하기 전에 null 검사를 꼭 해야 한다.
 */
public class LevelOrder {

    /**
     * 위에서 아래로, 같은 층은 왼쪽에서 오른쪽으로 훑은 값들을 한 줄로.
     * 빈 트리면 빈 리스트.
     */
    public static List<Integer> levelOrder(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 레벨별로 나눠 담은 결과.
     * 예: [[1], [2, 3], [4, 5]]
     */
    public static List<List<Integer>> levelOrderByLevel(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 트리의 최대 깊이. 빈 트리는 0, 노드 하나면 1.
     *
     * 재귀로 짜면 한 줄이다.
     *     1 + max(왼쪽 깊이, 오른쪽 깊이)
     */
    public static int maxDepth(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 오른쪽에서 트리를 봤을 때 보이는 값들 (위에서 아래로).
     * 즉 각 레벨의 가장 오른쪽 노드.
     *
     * LeetCode 199. Binary Tree Right Side View 와 같은 문제다.
     * 파이썬으로 이미 풀어 봤을 것이다. 자바로 옮겨 보자.
     */
    public static List<Integer> rightSideView(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }
}
