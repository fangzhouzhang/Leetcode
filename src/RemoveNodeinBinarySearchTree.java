public class RemoveNodeinBinarySearchTree {
	/**
	 * @param root: The root of the binary search tree.
	 * @param value: Remove the node with given value.
	 * @return: The root of the binary search tree after removal.
	 * time: o(log n)
	 * space: call stack o(h)
	 */
	public TreeNode removeNode(TreeNode root, int value) {
		// write your code here
		if (root == null) {
			return root;
		}
		if (root.val < value) {
			root.right = removeNode(root.right, value);
		} else if (root.val > value) {
			root.left = removeNode(root.left, value);
		} else {//three cases
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null || root.right == null) {
				return root.left != null ? root.left : root.right;
			} else {
				root.val  = findSmallest(root.right);
				root.right = removeNode(root.right, root.val);
			}
		}
		return root;
	}
	public int findSmallest(TreeNode root) {
		int res = root.val;
		while (root != null) {
			res = root.val;
			root = root.left;
		}
		return res;
	}
}
