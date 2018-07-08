public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isBSTHelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBSTHelper(root.left, min, root.val) && isBSTHelper(root.right, root.val, max);

    }
}
