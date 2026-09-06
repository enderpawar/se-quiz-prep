package prep;

import static mini.Assertions.assertEquals;
import static mini.Assertions.assertFalse;
import static mini.Assertions.assertNull;
import static mini.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import mini.Test;

public class BstOpsTest {

    /** 이 테스트 안에서만 쓰는 중위 순회. B1 을 안 풀었어도 이 문제는 돌아간다. */
    private static void inorder(TreeNode node, List<Integer> acc) {
        if (node == null) {
            return;
        }
        inorder(node.left, acc);
        acc.add(node.val);
        inorder(node.right, acc);
    }

    private static List<Integer> inorderOf(TreeNode root) {
        List<Integer> acc = new ArrayList<>();
        inorder(root, acc);
        return acc;
    }

    @Test
    void test1_insertShapesTree() {
        TreeNode root = BstOps.insert(null, 5);
        assertEquals(5, root.val);
        assertNull(root.left);
        assertNull(root.right);

        BstOps.insert(root, 3);
        BstOps.insert(root, 8);
        assertEquals(3, root.left.val);
        assertEquals(8, root.right.val);

        // 중복은 무시된다
        BstOps.insert(root, 3);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void test2_inorderIsSorted() {
        // BST 의 가장 중요한 성질: 중위 순회 = 오름차순
        TreeNode root = BstOps.fromArray(new int[]{5, 3, 8, 1, 4, 7, 9});
        assertEquals(List.of(1, 3, 4, 5, 7, 8, 9), inorderOf(root));

        TreeNode skewed = BstOps.fromArray(new int[]{1, 2, 3, 4});
        assertEquals(List.of(1, 2, 3, 4), inorderOf(skewed));

        assertNull(BstOps.fromArray(new int[]{}));
    }

    @Test
    void test3_contains() {
        TreeNode root = BstOps.fromArray(new int[]{5, 3, 8, 1, 4});
        assertTrue(BstOps.contains(root, 5));
        assertTrue(BstOps.contains(root, 1));
        assertTrue(BstOps.contains(root, 4));
        assertFalse(BstOps.contains(root, 6));
        assertFalse(BstOps.contains(root, 100));
        assertFalse(BstOps.contains(null, 1));
    }

    @Test
    void test4_isValidBst() {
        assertTrue(BstOps.isValidBst(BstOps.fromArray(new int[]{5, 3, 8, 1, 4})));
        assertTrue(BstOps.isValidBst(null));
        assertTrue(BstOps.isValidBst(new TreeNode(7)));

        //     5
        //    / \
        //   3   8
        //      / \
        //     4   9      4 는 5 보다 작은데 오른쪽 서브트리에 있다 → BST 아님
        TreeNode bad = new TreeNode(5,
                new TreeNode(3),
                new TreeNode(8, new TreeNode(4), new TreeNode(9)));
        assertFalse(BstOps.isValidBst(bad), "부모만 보면 통과하지만 조상 범위를 어겼다");

        //     2
        //    /
        //   3            왼쪽 자식이 더 크다 → BST 아님
        assertFalse(BstOps.isValidBst(new TreeNode(2, new TreeNode(3), null)));
    }

    @Test
    void test5_intBoundary() {
        // 경계값을 Integer.MIN_VALUE 로 초기화하면 여기서 틀린다
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        assertTrue(BstOps.isValidBst(root));

        TreeNode withMax = new TreeNode(0, null, new TreeNode(Integer.MAX_VALUE));
        assertTrue(BstOps.isValidBst(withMax));
    }
}
