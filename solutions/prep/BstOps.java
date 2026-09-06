package prep;

public class BstOps {

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        // val == root.val 이면 중복이므로 아무것도 하지 않는다
        return root;
    }

    public static boolean contains(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (val == node.val) {
                return true;
            }
            node = (val < node.val) ? node.left : node.right;   // 한쪽만 내려간다
        }
        return false;
    }

    public static TreeNode fromArray(int[] values) {
        TreeNode root = null;
        for (int v : values) {
            root = insert(root, v);
        }
        return root;
    }

    public static boolean isValidBst(TreeNode root) {
        // int 값의 양 끝(Integer.MIN_VALUE / MAX_VALUE)도 정상 값일 수 있으므로
        // 경계는 그보다 넓은 long 으로 잡는다.
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBst(TreeNode node, long lowerExclusive, long upperExclusive) {
        if (node == null) {
            return true;
        }
        if (node.val <= lowerExclusive || node.val >= upperExclusive) {
            return false;
        }
        // 왼쪽으로 가면 상한이 자기 값으로, 오른쪽으로 가면 하한이 자기 값으로 좁아진다
        return isValidBst(node.left, lowerExclusive, node.val)
                && isValidBst(node.right, node.val, upperExclusive);
    }
}
