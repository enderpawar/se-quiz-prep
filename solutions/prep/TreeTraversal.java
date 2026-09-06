package prep;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode node, List<Integer> acc) {
        if (node == null) {
            return;
        }
        acc.add(node.val);            // 루트
        preorder(node.left, acc);     // 왼쪽
        preorder(node.right, acc);    // 오른쪽
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode node, List<Integer> acc) {
        if (node == null) {
            return;
        }
        inorder(node.left, acc);      // 왼쪽
        acc.add(node.val);            // 루트
        inorder(node.right, acc);     // 오른쪽
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode node, List<Integer> acc) {
        if (node == null) {
            return;
        }
        postorder(node.left, acc);    // 왼쪽
        postorder(node.right, acc);   // 오른쪽
        acc.add(node.val);            // 루트
    }
}
