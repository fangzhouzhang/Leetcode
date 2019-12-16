import java.util.*;

public class _863AllNodesDistanceKinBinaryTree {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
		buildGraph(map, root);
		bfs(map, target, K, res);
		return res;
	}

	private void bfs(Map<TreeNode, Set<TreeNode>> map, TreeNode root, int k, List<Integer> res) {
		Queue<TreeNode> q = new LinkedList<>();
		Set<TreeNode> set = new HashSet<>();
		q.add(root);
		set.add(root);
		int dis = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (dis == k) res.add(node.val);
				Set<TreeNode> neighbors = map.get(node);
				if (neighbors == null) continue;
				for (TreeNode n : neighbors) {
					if (!set.contains(n)) {
						q.add(n);
						set.add(n);
					}
				}
			}
			dis++;
		}
	}

	private void buildGraph(Map<TreeNode, Set<TreeNode>> map, TreeNode root) {
		if (root == null) return;
		if (!map.containsKey(root)) map.put(root, new HashSet<>());
		if (root.left != null) {
			if (!map.containsKey(root.left)) map.put(root.left, new HashSet<>());
			map.get(root).add(root.left);
			map.get(root.left).add(root);
			buildGraph(map, root.left);
		}
		if (root.right != null) {
			if (!map.containsKey(root.right)) map.put(root.right, new HashSet<>());
			map.get(root).add(root.right);
			map.get(root.right).add(root);
			buildGraph(map, root.right);
		}
	}
}
