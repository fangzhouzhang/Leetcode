import java.util.HashSet;
import java.util.Set;

public class _1676LowestCommonAncestorofaBinaryTreeIV {
	private Set<TreeNode> set;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		if (root == null) return root;
		set = new HashSet<>();
		for (TreeNode node : nodes) set.add(node);
		return dfs(root);
	}

	private TreeNode dfs(TreeNode root) {
		if (root == null) return null;
		if (set.contains(root)) return root;
		TreeNode left = dfs(root.left);
		TreeNode right = dfs(root.right);
		if (left != null && right != null) return root;
		if (left != null || right != null) return left != null ? left : right;
		return null;
	}
}
