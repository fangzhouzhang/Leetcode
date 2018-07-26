public class MaximumPathSumBinaryTreeI {
	/**
	 * param root: root of tree
	 * return max sum from one leaf to another leaf node
	 * time: o(n)
	 * space: call stack o(h) variable o(1)
	 */
	public int globalMax = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		// Write your solution here
		int singleMax = getSinglePathMax(root);
		return globalMax;
	}
	public int getSinglePathMax(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getSinglePathMax(root.left);
		int right = getSinglePathMax(root.right);
		if (root.left != null && root.right != null) {
			globalMax = Math.max(globalMax, left + right + root.val);
			return Math.max(left, right) + root.val;
		} else if (root.left != null || root.right != null) {
			return root.left != null ? left + root.val : right + root.val;
		} else {
			return root.val;
		}


	}
}
