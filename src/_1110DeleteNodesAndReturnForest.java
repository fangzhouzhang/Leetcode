import java.util.*;

public class _1110DeleteNodesAndReturnForest {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		if (root == null) return new ArrayList<>();
		List<TreeNode> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int del : to_delete) set.add(del);
		dfs(root, set, res, true);
		return res;
	}

	private TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean father) {
		if (root == null) return null;
		boolean nextFather = set.contains(root.val);
		root.left = dfs(root.left, set, res, nextFather);
		root.right = dfs(root.right, set, res, nextFather);
		if (father && !nextFather) res.add(root);
		return nextFather ? null : root;
	}
}
