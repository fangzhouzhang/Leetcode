public class _998MaximumBinaryTreeII {
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);
		if (root.val < val) {
			TreeNode head = new TreeNode(val);
			head.left = root;
			return head;
		} else {
			TreeNode curRight = insertIntoMaxTree(root.right, val);
			root.right = curRight;
			return root;
		}
	}
}
