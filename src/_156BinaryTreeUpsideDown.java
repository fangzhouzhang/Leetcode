public class _156BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) return null;
		if (root.left == null && root.right == null) return root;
		else if (root.left != null && root.right == null) {
			TreeNode pleft = root.left;
			TreeNode pright =root.right;
			TreeNode res = upsideDownBinaryTree(root.left);
			// upsideDownBinaryTree(root->right);
			root.left = null;
			// root.right = null;
			pleft.right = root;
			return res;
		} else {
			TreeNode pleft = root.left;
			TreeNode pright =root.right;
			TreeNode res = upsideDownBinaryTree(root.left);
			upsideDownBinaryTree(root.right);
			root.left = null;
			root.right = null;
			pleft.right = root;
			pleft.left = pright;
			return res;
		}
	}
}
