import java.util.HashMap;
import java.util.Map;

public class _889ConstructBinaryTreefromPreorderandPostorderTraversal {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (pre == null || pre.length == 0 || post == null || post.length == 0) return null;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < post.length; i++) map.put(post[i], i);
		return dfs(pre, 0, post, 0, pre.length, map);
	}

	private TreeNode dfs(int[] pre, int preIdx, int[] post, int postIdx, int toBeProcess, Map<Integer, Integer> map) {
		if (toBeProcess == 0) return null;
		TreeNode root = new TreeNode(pre[preIdx]);
		if (toBeProcess == 1) return root;
		int target = pre[preIdx + 1];
		int leftSize = map.get(target) - postIdx + 1;
		root.left = dfs(pre, preIdx + 1, post, postIdx, leftSize, map);
		root.right = dfs(pre, preIdx + 1 + leftSize, post, postIdx + leftSize, toBeProcess - 1 - leftSize, map);
		return root;
	}
}
