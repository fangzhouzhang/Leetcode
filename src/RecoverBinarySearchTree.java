public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode[] vals = new TreeNode[2];
		TreeNode[] prev = new TreeNode[1];

		dfs(vals, root, prev);



		int temp = vals[0].val;
		vals[0].val = vals[1].val;
		vals[1].val = temp;
		return;
	}
	private void dfs(TreeNode[] vals, TreeNode root, TreeNode[] prev) {
		if (root == null) {
			return;
		}
		dfs(vals, root.left, prev);


		if (prev[0] == null) {//first one
			prev[0] = root;
		} else {//prev != null
			// System.out.print("prev " + prev.val + "  root " + root.val + " ");
			// System.out.println();
			if (prev[0].val >= root.val) {
				if (vals[0] == null) {
					vals[0] = prev[0];
				}
				vals[1] = root;
			}
			prev[0] = root;
			// System.out.println("prev " + prev.val);
		}

		dfs(vals, root.right, prev);

	}
}
