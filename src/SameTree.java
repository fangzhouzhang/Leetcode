public class SameTree {
	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		//p and q are not null
		if (p.val != q.val) {
			return false;
		}
		//p and q are same val
		if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
			return true;
		} else {
			return false;
		}
	}
}
