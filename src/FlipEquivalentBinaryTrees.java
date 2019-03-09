public class FlipEquivalentBinaryTrees {
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		//both roots are not null
		if (root1.val != root2.val) {
			return false;
		}

		//root1.val == root2.val
		if ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))) {
			return true;
		} else {
			return false;
		}
	}
}
