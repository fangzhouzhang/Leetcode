public class _965UnivaluedBinaryTree {
	public boolean isUnivalTree(TreeNode root) {
		if (root == null) return false;
		return dfs(root.left, root.val) && dfs(root.right, root.val);
	}

	private boolean dfs(TreeNode root, int val) {
		if (root == null) return true;
		if (root.val != val) return false;
		return dfs(root.left, root.val) && dfs(root.right, root.val);
	}
}
