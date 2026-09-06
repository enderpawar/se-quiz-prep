package prep;

import static mini.Assertions.assertEquals;

import java.util.List;
import mini.Test;

public class LevelOrderTest {

    /**
     *         1
     *        / \
     *       2   3
     *      / \
     *     4   5
     */
    private static TreeNode full() {
        return TreeNode.of(1, 2, 3, 4, 5);
    }

    /**
     *         1
     *        / \
     *       2   3
     *        \   \
     *         5   4
     */
    private static TreeNode sparse() {
        return TreeNode.of(1, 2, 3, null, 5, null, 4);
    }

    @Test
    void test1_levelOrder() {
        assertEquals(List.of(1, 2, 3, 4, 5), LevelOrder.levelOrder(full()));
        assertEquals(List.of(1, 2, 3, 5, 4), LevelOrder.levelOrder(sparse()));
        assertEquals(List.of(), LevelOrder.levelOrder(null));
    }

    @Test
    void test2_levelOrderByLevel() {
        assertEquals(
                List.of(List.of(1), List.of(2, 3), List.of(4, 5)),
                LevelOrder.levelOrderByLevel(full()));
        assertEquals(
                List.of(List.of(1), List.of(2, 3), List.of(5, 4)),
                LevelOrder.levelOrderByLevel(sparse()));
        assertEquals(List.of(), LevelOrder.levelOrderByLevel(null));
    }

    @Test
    void test3_maxDepth() {
        assertEquals(3, LevelOrder.maxDepth(full()));
        assertEquals(3, LevelOrder.maxDepth(sparse()));
        assertEquals(1, LevelOrder.maxDepth(new TreeNode(7)));
        assertEquals(0, LevelOrder.maxDepth(null));
        assertEquals(3, LevelOrder.maxDepth(
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))));
    }

    @Test
    void test4_rightSideView() {
        assertEquals(List.of(1, 3, 5), LevelOrder.rightSideView(full()));
        assertEquals(List.of(1, 3, 4), LevelOrder.rightSideView(sparse()));
        assertEquals(List.of(), LevelOrder.rightSideView(null));

        // 왼쪽으로만 뻗어도 그 노드가 "오른쪽에서 보이는" 노드다
        TreeNode leftOnly = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        assertEquals(List.of(1, 2, 3), LevelOrder.rightSideView(leftOnly));
    }
}
