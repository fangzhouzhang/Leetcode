public class SmallestSubtreewithalltheDeepestNodes {
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) return null;
		return dfs(root).res;
	}

	private Pair dfs(TreeNode root) {
		if (root == null) {
			return new Pair(0, null);
		}

		Pair l = dfs(root.left);
		Pair r = dfs(root.right);
		TreeNode n = l.h == r.h ? root : l.h > r.h ? l.res : r.res;
		return new Pair(Math.max(l.h, r.h) + 1, n);
	}

	private class Pair {
		int h;
		TreeNode res;
		public Pair(int h, TreeNode res) {
			this.h = h;
			this.res = res;
		}
	}

}
