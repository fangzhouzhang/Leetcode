import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
		if (root == null) return new ArrayList<List<String>>();
		int h = getHeight(root);
		int w = (1 << h) - 1;
		List<List<String>> res = new ArrayList<>(h);
		List<String> tmp = new ArrayList<>();
		for (int i = 0; i < w; i++) tmp.add("");

		for (int i = 0; i < h; i++) res.add(new ArrayList<>(tmp));

		dfs(res, root, 0, w - 1, 0);
		return res;
	}

	private void dfs(List<List<String>> res, TreeNode root, int start, int end, int h) {
		if (start > end || root == null) return;
		int mid = start + (end - start) / 2;
		res.get(h).set(mid, root.val + "");
		dfs(res, root.left, start, mid - 1, h + 1);
		dfs(res, root.right, mid + 1, end, h + 1);
	}

	private int getHeight(TreeNode root) {
		if (root == null) return 0;
		int l = getHeight(root.left);
		int r = getHeight(root.right);
		return Math.max(l, r) + 1;
	}
}
