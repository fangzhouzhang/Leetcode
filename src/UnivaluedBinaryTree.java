public class UnivaluedBinaryTree {
	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isUnival(root, root.val);
	}
	private boolean isUnival(TreeNode root, int val) {
		if (root == null) {
			return true;
		}

		if (root.val != val) {
			return false;
		}

		return isUnival(root.left, root.val) &&
				isUnival(root.right, root.val);
	}
}
