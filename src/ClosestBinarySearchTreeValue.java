public class ClosestBinarySearchTreeValue {
	/**
	 * @param root: the given BST
	 * @param target: the given target
	 * @return: the value in the BST that is closest to the target
	 * time: o(n)
	 * space: o(1)
	 */
	public double minDiff = Double.MAX_VALUE;
	public int closestValue(TreeNode root, double target) {
		// write your code here
		if (root == null) {
			return -1;
		}
		int temp = root.val;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val < target) {
				if (Math.abs(cur.val - target) < minDiff) {
					minDiff = Math.abs(cur.val - target);
					temp = cur.val;
				}
				cur = cur.right;
			} else if (cur.val > target) {
				if (Math.abs(cur.val - target) < minDiff) {
					minDiff = Math.abs(cur.val - target);
					temp = cur.val;
				}
				cur = cur.left;
			} else {
				return cur.val;
			}
		}
		return temp;
	}
}
