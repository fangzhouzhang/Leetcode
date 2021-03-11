public class _563BinaryTreeTilt {
	private int sum = 0;
	public int findTilt(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return sum;
	}

	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		sum += Math.abs(left - right);
		return left + right +root.val;
	}
}
