public class _285InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) return root;
		TreeNode cur = p.right == null ? root : p.right;
		TreeNode res = null;
		while (cur != null) {
			if (cur.val > p.val) {
				res = cur;
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return res;
	}
}
