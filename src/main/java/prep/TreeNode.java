package prep;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 이진 트리 노드. 이 파일은 이미 완성되어 있으니 고칠 필요 없다.
 *
 * LeetCode 에서 쓰는 것과 똑같은 모양이다.
 * 파이썬으로 치면:
 *     class TreeNode:
 *         def __init__(self, val=0, left=None, right=None):
 *             self.val = val
 *             self.left = left
 *             self.right = right
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 레벨 순서 배열로 트리를 만든다. null 은 빈 자리를 뜻한다.
     *
     * 예: TreeNode.of(1, 2, 3, null, 5)
     *
     *         1
     *        / \
     *       2   3
     *        \
     *         5
     */
    public static TreeNode of(Integer... levelOrder) {
        if (levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int i = 1;
        while (i < levelOrder.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (i < levelOrder.length) {
                Integer leftVal = levelOrder[i++];
                if (leftVal != null) {
                    node.left = new TreeNode(leftVal);
                    queue.add(node.left);
                }
            }
            if (i < levelOrder.length) {
                Integer rightVal = levelOrder[i++];
                if (rightVal != null) {
                    node.right = new TreeNode(rightVal);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
