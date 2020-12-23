public class _979DistributeCoinsinBinaryTree {
	int res = 0;
	public int distributeCoins(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return res;
	}

	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		res += Math.abs(left) + Math.abs(right);
		return root.val - 1 + left + right;
	}
}
