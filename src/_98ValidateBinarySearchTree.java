public class _98ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean dfs(TreeNode root, long min, long max) {
		if (root == null) return true;
		if (root.val <= min || root.val >= max) return false;
		return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
	}
}
