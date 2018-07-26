public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     * time: o(nlogn) space:o(h)
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }

    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
	 * time : o(n) space: o(h)
     */
    public boolean isBalanced1(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        int left = getHeight1(root.left);
        int right = getHeight1(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }
    public int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
