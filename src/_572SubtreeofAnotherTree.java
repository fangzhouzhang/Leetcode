public class _572SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		else if (s == null || t == null) return false;
		boolean res = isSubtree(s.left, t) || isSubtree(s.right, t);
		return s.val == t.val ? (sameVal(s.left, t.left) && sameVal(s.right, t.right)) || res : res;
	}

	private boolean sameVal(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		else if (s == null || t == null) return false;
		if (s.val == t.val) return sameVal(s.left, t.left) && sameVal(s.right, t.right);
		else return false;
	}
}
