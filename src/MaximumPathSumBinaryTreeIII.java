public class MaximumPathSumBinaryTreeIII {
	/**
	 *
	 * @param root
	 * @return
	 * time : o(n)
	 * space : call stack o(h)
	 * 			int[] o(1)
	 */
	public int maxPathSum(TreeNode root) {
		// Write your solution here
		int[] globalMax = {Integer.MIN_VALUE};
		getPathMaxSum(root, globalMax, 0);
		return globalMax[0];
	}
	public void getPathMaxSum(TreeNode root, int[] globalMax, int prefixPathSum) {
		if (root == null) {
			return;
		}
		if (prefixPathSum >= 0) {
			prefixPathSum += root.val;
		} else {
			prefixPathSum = root.val;
		}
		globalMax[0] = Math.max(prefixPathSum, globalMax[0]);
		getPathMaxSum(root.left, globalMax, prefixPathSum);
		getPathMaxSum(root.right, globalMax, prefixPathSum);
		return;
	}
}
