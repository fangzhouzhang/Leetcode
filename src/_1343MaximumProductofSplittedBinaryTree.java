public class _1343MaximumProductofSplittedBinaryTree {
	private int M = 1000000007;
	public int maxProduct(TreeNode root) {
		if (root == null) return 0;
		long[] res = new long[1];
		res[0] = Integer.MIN_VALUE;
		long sum = getSum(root);
		dfs(root, res, sum);
		return (int)(res[0] % M);
	}

	private long getSum(TreeNode root) {
		if (root == null) return 0;
		long left = getSum(root.left);
		long right = getSum(root.right);
		return left + right + root.val;
	}

	private long dfs(TreeNode root, long[] res, long sum) {
		if (root == null) return 0;
		long left = dfs(root.left, res, sum);
		long right = dfs(root.right, res, sum);
		long curMax = Math.max(((sum - right) * right) , ((sum - left) * left));
		res[0] = Math.max(curMax, res[0]);
		return left + right + root.val;
	}
}
