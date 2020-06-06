public class _226InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		invertTree(root.left);
		invertTree(root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}
