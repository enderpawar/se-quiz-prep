package prep;

import java.util.List;

/**
 * [B1] 이진 트리 순회. 단답형으로 가장 나오기 쉬운 주제다.
 *
 * 전위(preorder)  : 루트 → 왼쪽 → 오른쪽
 * 중위(inorder)   : 왼쪽 → 루트 → 오른쪽
 * 후위(postorder) : 왼쪽 → 오른쪽 → 루트
 *
 * "전/중/후"는 루트를 언제 방문하느냐를 가리킨다. 이것만 기억하면 헷갈리지 않는다.
 *
 * 파이썬으로는 이렇게 짰을 것이다.
 *     def preorder(node, acc):
 *         if not node: return
 *         acc.append(node.val)
 *         preorder(node.left, acc)
 *         preorder(node.right, acc)
 *
 * 자바도 구조는 같다. 결과를 담을 List 를 만들고 재귀 도우미 메서드에 넘긴다.
 */
public class TreeTraversal {

    /** 전위 순회 결과. 빈 트리(null)면 빈 리스트. */
    public static List<Integer> preorder(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }

    /** 중위 순회 결과. */
    public static List<Integer> inorder(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }

    /** 후위 순회 결과. */
    public static List<Integer> postorder(TreeNode root) {
        throw new UnsupportedOperationException("TODO");
    }
}
