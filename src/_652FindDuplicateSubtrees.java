import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _652FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		if (root == null) return res;
		dfs(root, res, new HashMap<String, Integer>());
		return res;
	}

	private String dfs(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
		if (root == null) return "#";
		String key = root.val + "," + dfs(root.left, res, map) + "," + dfs(root.right, res, map);
		map.put(key, map.getOrDefault(key, 0) + 1);
		if (map.get(key) == 2) res.add(root);
		return key;
	}
}
