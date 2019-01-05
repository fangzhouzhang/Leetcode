public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			return Math.min(left, right) + 1;
		} else if (root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			return minDepth(root.right) + 1;
		}

	}
}
