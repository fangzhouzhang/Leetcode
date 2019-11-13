public class _124BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode root, int[] res) {
		if (root == null) return 0;
		int left = Math.max(0, dfs(root.left, res));
		int right = Math.max(0, dfs(root.right, res));
		res[0] = Math.max(res[0], left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
