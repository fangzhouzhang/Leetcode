import java.util.*;

public class AllNodesDistanceKinBinaryTree {
	Map<TreeNode, List<TreeNode>> map = new HashMap<>();
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new ArrayList<>();
		buildGraph(root, null);
		Queue<TreeNode> q = new LinkedList<>();
		Set<TreeNode> set = new HashSet<>();
		q.add(target);
		set.add(target);
		while (!q.isEmpty()) {
			int size = q.size();
			if (K ==0) {
				for (int i = 0; i < size; i++) {
					res.add(q.poll().val);
				}
				return res;
			}
			for (int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				for (TreeNode node : map.get(n)) {
					if (!set.contains(node)) {
						set.add(node);
						q.add(node);
					}
				}
			}
			K--;
		}
		return res;
	}

	private void buildGraph(TreeNode root, TreeNode parent) {
		if (root == null) return;
		if (!map.containsKey(root)) {
			map.put(root, new ArrayList<>());
			if (parent != null) {
				map.get(root).add(parent);
				map.get(parent).add(root);
			}
			buildGraph(root.left, root);
			buildGraph(root.right, root);
		}
	}
}
