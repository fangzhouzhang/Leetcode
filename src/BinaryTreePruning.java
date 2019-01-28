public class BinaryTreePruning {
	/**
	 * time: o(n) space: o(n)
	 * @param root
	 * @return
	 */
	public TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null) {
			return root.val == 0 ? null : root;
		}
		return root;
	}
}
