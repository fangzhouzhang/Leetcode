public class InsertNodeinaBinarySearchTree {
	/**
	 * @param root: The root of the binary search tree.
	 * @param node: insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 * time: o(log n) space: o(1)
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		// write your code here
		if (root == null) {
			return node;
		}
		TreeNode parent = root;
		TreeNode cur = root;
		while (cur != null) {
			parent = cur;
			if (cur.val > node.val) {
				cur = cur.left;
			} else if (cur.val < node.val) {
				cur = cur.right;
			}
		}
		if (parent.val < node.val) {
			parent.right = node;
		} else {
			parent.left = node;
		}
		return root;
	}
}
