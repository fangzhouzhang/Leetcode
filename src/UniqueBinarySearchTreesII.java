import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();
		if (n < 0) {
			res.add(null);
			return res;
		} else if (n < 1) {
			return res;
		}
		int[] elements = new int[n];
		for (int i = 0; i < n; i++) {
			elements[i] = i + 1;
		}


		return dfs(elements, 0, elements.length - 1);
	}
	private List<TreeNode> dfs(int[] elements, int start, int end) {
		List<TreeNode> res = new ArrayList<>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = dfs(elements, start, i - 1);
			List<TreeNode> rights = dfs(elements, i + 1, end);

			for (TreeNode left: lefts) {
				for (TreeNode right: rights) {
					TreeNode root = new TreeNode(elements[i]);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}

		}
		return res;
	}
}
