package prep;

import static mini.Assertions.assertEquals;

import java.util.List;
import mini.Test;

public class TreeTraversalTest {

    /**
     *         1
     *        / \
     *       2   3
     *      / \
     *     4   5
     */
    private static TreeNode sample() {
        return TreeNode.of(1, 2, 3, 4, 5);
    }

    @Test
    void test1_preorder() {
        assertEquals(List.of(1, 2, 4, 5, 3), TreeTraversal.preorder(sample()));
        assertEquals(List.of(), TreeTraversal.preorder(null));
        assertEquals(List.of(7), TreeTraversal.preorder(new TreeNode(7)));
    }

    @Test
    void test2_inorder() {
        assertEquals(List.of(4, 2, 5, 1, 3), TreeTraversal.inorder(sample()));
        assertEquals(List.of(), TreeTraversal.inorder(null));
    }

    @Test
    void test3_postorder() {
        assertEquals(List.of(4, 5, 2, 3, 1), TreeTraversal.postorder(sample()));
        assertEquals(List.of(), TreeTraversal.postorder(null));
    }

    /**
     * 한쪽으로만 뻗은 트리에서도 맞는지 확인.
     *     1
     *      \
     *       2
     *        \
     *         3
     */
    @Test
    void test4_skewedTree() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        assertEquals(List.of(1, 2, 3), TreeTraversal.preorder(root));
        assertEquals(List.of(1, 2, 3), TreeTraversal.inorder(root));
        assertEquals(List.of(3, 2, 1), TreeTraversal.postorder(root));
    }
}
