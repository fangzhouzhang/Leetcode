public class LowestCommonAncestorofDeepestLeaves {
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) return null;
		return dfs(root, 0).node;
	}

	private Pair dfs(TreeNode root, int depth) {
		if (root == null) return new Pair(null, depth);
		Pair l = dfs(root.left, depth + 1);
		Pair r = dfs(root.right, depth + 1);
		if (l.depth == r.depth) {
			//pay attention to l.depth here
			return new Pair(root, l.depth);
		} else {
			return l.depth > r.depth ? l : r;
		}
	}

	private class Pair{
		TreeNode node;
		int depth;
		public Pair(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
