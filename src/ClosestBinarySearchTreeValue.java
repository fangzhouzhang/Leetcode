public class ClosestBinarySearchTreeValue {
	/**
	 * @param root: the given BST
	 * @param target: the given target
	 * @return: the value in the BST that is closest to the target
	 * time: o(n)
	 * space: o(1)
	 */
	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return -1;
		}
		int[] res = new int[1];
		res[0] = root.val;
		return helper(root, target, res);

	}
	private int helper(TreeNode root, double target, int[] res) {
		if (root == null) {
			return res[0];
		}
		if (root.val == target) {
			return root.val;
		} else if (root.val < target) {
			if (Math.abs(root.val - target) < Math.abs(res[0] - target)) {
				res[0] = root.val;
			}
			return helper(root.right, target, res);
		} else {
			if (Math.abs(root.val - target) < Math.abs(res[0] - target)) {
				res[0] = root.val;
			}
			return helper(root.left, target, res);
		}
	}
}
