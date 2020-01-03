import java.util.*;

public class _1110DeleteNodesAndReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> res = new ArrayList<>();
		if (root == null) return res;
		Set<Integer> set = new HashSet<>();
		for (int n : to_delete) set.add(n);
		dfs(root, null, set, res);
		return res;
	}

	private void dfs(TreeNode root, TreeNode parent, Set<Integer> set, List<TreeNode> res) {
		if (root == null) return;
		dfs(root.left, root, set, res);
		if (root.left != null && set.contains(root.left.val)) root.left = null;
		dfs(root.right, root, set, res);
		if (root.right != null && set.contains(root.right.val)) root.right = null;
		if ((!set.contains(root.val)) && (parent == null || set.contains(parent.val))) res.add(root);
	}
}
