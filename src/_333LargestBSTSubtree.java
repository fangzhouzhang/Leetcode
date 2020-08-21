public class _333LargestBSTSubtree {
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}

	private Result dfs(TreeNode root, int[] res) {
		if (root == null) return new Result(0, Long.MAX_VALUE, Long.MIN_VALUE);
		Result left = dfs(root.left, res);
		Result right = dfs(root.right, res);
		if (left.size == -1 ||
				right.size == -1 ||
				root.val <= left.upper ||
				root.val >= right.lower) {
			return new Result(-1, 0, 0);
		}
		res[0] = Math.max(res[0], 1 + left.size + right.size);
		return new Result(1 + left.size + right.size, Math.min(left.lower, root.val), Math.max(root.val, right.upper));
	}

	private class Result {
		int size;
		long lower;
		long upper;
		public Result(int size, long lower, long upper) {
			this.size = size;
			this.lower = lower;
			this.upper = upper;
		}
	}
}
