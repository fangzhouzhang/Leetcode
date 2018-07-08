public class SymmetricTree {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself
     * time : o(n) space : o(h)
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isSymm(root.left, root.right);
    }
    public boolean isSymm(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val == n2.val) {
            return isSymm(n1.left, n2.right) && isSymm(n1.right, n2.left);
        } else {
            return false;
        }
    }
}
