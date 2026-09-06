package prep;

/**
 * [B3] 이진 탐색 트리(BST).
 *
 * 규칙: 어떤 노드든 "왼쪽 서브트리의 모든 값 < 자기 값 < 오른쪽 서브트리의 모든 값"
 *
 * 시험에 자주 나오는 성질
 *   - BST 를 중위 순회하면 오름차순 정렬된 순서가 나온다. (이게 핵심)
 *   - 탐색/삽입은 평균 O(log n), 한쪽으로 치우치면 최악 O(n).
 *   - 노드가 n 개인 트리의 간선은 항상 n - 1 개다.
 */
public class BstOps {

    /**
     * BST 규칙에 맞게 val 을 넣고 루트를 돌려준다.
     * 이미 있는 값이면 아무것도 하지 않는다.
     * root 가 null 이면 새 노드가 루트가 된다.
     *
     * 재귀로 짜면 자연스럽다.
     *     if (root == null) return new TreeNode(val);
     *     if (val < root.val) root.left = insert(root.left, val);
     *     else if (val > root.val) root.right = insert(root.right, val);
     *     return root;
     */
    public static TreeNode insert(TreeNode root, int val) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * val 이 트리 안에 있는지. BST 성질을 이용해 한쪽만 내려가야 한다.
     * (전체를 다 뒤지면 BST 를 쓰는 의미가 없다)
     */
    public static boolean contains(TreeNode root, int val) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 배열의 값을 앞에서부터 차례로 insert 해서 만든 BST 의 루트.
     * 빈 배열이면 null.
     */
    public static TreeNode fromArray(int[] values) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 이 트리가 올바른 BST 인지 판정한다.
     *
     * ★ 흔한 오답 ★
     *   "각 노드에서 left.val < val < right.val 만 확인" — 이건 틀렸다.
     *   바로 아래 자식만 보면 안 되고, 조상들이 정한 범위 전체를 지켜야 한다.
     *
     * 힌트: 재귀에 (하한, 상한)을 같이 넘긴다.
     *       왼쪽으로 갈 때는 상한이 부모 값으로, 오른쪽으로 갈 때는 하한이 부모 값으로 좁아진다.
     *       범위에 Long 이나 null 을 쓰면 int 경계값 처리가 편하다.
     */
    public static boolean isValidBst(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }
}
