import java.util.*;

public class _1302DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {
		if (root == null) return 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		int res = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (!map.containsKey(level)) map.put(level, new ArrayList<Integer>());
				map.get(level).add(node.val);
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
			level++;
		}
		List<Integer> list = map.get(level - 1);
		for (int n : list) res += n;
		return res;
	}
}
