import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		Map<Integer, List<Integer>> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				if (pair.node.left != null) {
					q.add(new Pair(pair.node.left, pair.num - 1));
				}
				if (pair.node.right != null) {
					q.add(new Pair(pair.node.right, pair.num + 1));
				}
				if (map.containsKey(pair.num)) {
					List<Integer> list = map.get(pair.num);
					list.add(pair.node.val);
					map.put(pair.num, list);
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(pair.node.val);
					map.put(pair.num, list);
				}
			}
		}
		for (Integer key: map.keySet()) {
			res.add(new ArrayList<>(map.get(key)));
		}
		return res;
	}
	private class Pair {
		TreeNode node;
		int num;
		public Pair(TreeNode node, int num) {
			this.node = node;
			this.num = num;
		}
	}
}
