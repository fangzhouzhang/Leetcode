import java.util.HashMap;
import java.util.Map;

public class _889ConstructBinaryTreefromPreorderandPostorderTraversal {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (pre == null || post == null) return null;
		if (pre.length == 0 || post.length == 0) return null;
		Map<Integer, Integer> p = new HashMap<>();
		for (int i = 0; i < post.length; i++) {
			p.put(post[i], i);
		}
		return dfs(pre, 0, post, 0, post.length, p);
	}

	private TreeNode dfs(int[] pre, int i, int[] post, int j, int size, Map<Integer, Integer> p) {
		if (size == 0) return null;
		if (size == 1) return new TreeNode(pre[i]);
		TreeNode root = new TreeNode(pre[i]);
		int nextLeftNodeVal = pre[i + 1];
		int leftSize = p.get(nextLeftNodeVal) - j + 1;
		root.left = dfs(pre, i + 1, post, j, leftSize, p);
		root.right = dfs(pre, i + 1 + leftSize, post, p.get(nextLeftNodeVal) + 1,  size - 1 - leftSize, p);
		return root;
	}
}
