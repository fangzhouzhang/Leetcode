public class MaximumPathSumBinaryTreeII {
	/**
	 * @param root: The root of binary tree.
	 * @return: An integer
	 * time : o(n)
	 * space : call stack o(h)
	 */
	public int globalMax = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		// write your code here
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int temp = getPathMax(root);
		return globalMax;
	}
	public int getPathMax(TreeNode root) {
		if (root == null) {
			return 0;//base case
		}
		int left = getPathMax(root.left) >= 0 ? getPathMax(root.left) : 0;
		int right = getPathMax(root.right) >= 0 ? getPathMax(root.right) : 0;
		globalMax = left + right + root.val > globalMax ? left + right + root.val : globalMax;
		return left > right ? left + root.val : right + root.val;
	}
}
