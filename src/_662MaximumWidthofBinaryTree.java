import java.util.ArrayList;
import java.util.List;

public class _662MaximumWidthofBinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		List<Integer> list = new ArrayList<>();
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		dfs(root, list, 0, 1, res);
		return res[0];
	}

	private void dfs(TreeNode root, List<Integer> list, int level, int idx, int[] res) {
		if (root == null) return;
		if (level == list.size()) {
			list.add(idx);
		}
		res[0] = Math.max(res[0], idx - list.get(level) + 1);
		dfs(root.left, list, level + 1, idx * 2, res);
		dfs(root.right, list, level + 1, idx * 2 + 1, res);
	}
}
