import java.util.*;

public class ClosestLeafinaBinaryTree {
	private TreeNode start;
	public int findClosestLeaf(TreeNode root, int k) {
		Map<TreeNode, List<TreeNode>> map = new HashMap<>();
		buildGraph(map, root, null, k);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(start);
		Set<TreeNode> set = new HashSet<>();
		set.add(start);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				// System.out.println(n.val);
				if (n.left == null && n.right == null) return n.val;
				if (map.get(n) == null) continue;
				for (TreeNode node : map.get(n)) {
					if (!set.contains(node)) {
						q.add(node);
						set.add(node);
					}
				}
			}
		}
		return -1;
	}

	private void buildGraph(Map<TreeNode, List<TreeNode>> map, TreeNode root, TreeNode parent, int k) {
		if (root == null) return;
		if (root.val == k) start = root;
		if (parent != null) {
			if (!map.containsKey(parent)) {
				List<TreeNode> nodes = new ArrayList<>();
				nodes.add(root);
				map.put(parent, nodes);
			} else {
				List<TreeNode> nodes = map.get(parent);
				nodes.add(root);
			}

			if (!map.containsKey(root)) {
				List<TreeNode> nodes = new ArrayList<>();
				nodes.add(parent);
				map.put(root, nodes);
			} else {
				List<TreeNode> nodes = map.get(root);
				nodes.add(parent);
			}
		}
		buildGraph(map, root.left, root, k);
		buildGraph(map, root.right, root, k);
	}
}
