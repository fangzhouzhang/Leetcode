public class ClosestBinarySearchTreeValue {
	/**
	 * @param root: the given BST
	 * @param target: the given target
	 * @return: the value in the BST that is closest to the target
	 * time: o(n)
	 * space: o(1)
	 */
	int[] res = new int[1];
	public int closestValue(TreeNode root, double target) {
		if (root == null) return 0;

		res[0] = root.val;
		dfs(root, target);
		return res[0];
	}

	private void dfs(TreeNode root, double target) {
		if (root == null) return;
		if (Math.abs(target - res[0]) > Math.abs(target - root.val)) res[0] = root.val;
		if (root.val < target) dfs(root.right, target);
		if (root.val > target) dfs(root.left, target);
	}
}
