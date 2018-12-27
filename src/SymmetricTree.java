public class SymmetricTree {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself
     * time : o(n) space : o(h)
     */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return checkSymm(root.left, root.right);
	}
	private boolean checkSymm(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		} else if (n1 == null || n2 == null) {
			return false;
		}

		//both nodes are not null
		int val1 = n1.val;
		int val2 = n2.val;
		if (val1 != val2) {
			return false;
		}
		return checkSymm(n1.left, n2.right) &&
				checkSymm(n1.right, n2.left);
	}
}
