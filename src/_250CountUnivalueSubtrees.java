public class _250CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) return 0;
		return dfs(root).sum;
	}

	private Result dfs(TreeNode root) {
		if (root == null) return new Result(true, 0);
		Result left = dfs(root.left);
		Result right = dfs(root.right);
		if (!left.uni || !right.uni) return new Result(false, left.sum + right.sum);
		if ((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) return new Result(true, left.sum + right.sum + 1);
		return new Result(false, left.sum + right.sum);
	}

	private class Result {
		boolean uni;
		int sum;
		public Result(boolean u, int s) {
			uni = u;
			sum = s;
		}
	}
}
