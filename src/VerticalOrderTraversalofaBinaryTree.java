import java.util.*;

public class VerticalOrderTraversalofaBinaryTree {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<Integer, List<Pair>> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				if (map.containsKey(pair.pos)) {
					List<Pair> list = map.get(pair.pos);
					list.add(pair);
					map.put(pair.pos, list);
				} else {
					List<Pair> list = new ArrayList<>();
					list.add(pair);
					map.put(pair.pos, list);
				}

				if (pair.node.left != null) {
					q.add(new Pair(pair.node.left, pair.pos - 1, pair.depth + 1));
				}
				if (pair.node.right != null) {
					q.add(new Pair(pair.node.right, pair.pos + 1, pair.depth + 1));
				}
			}
		}

		for (Integer key : map.keySet()) {
			List<Integer> temp = new ArrayList<>();
			List<Pair> list = map.get(key);
			Collections.sort(list, new myComparator());
			for (Pair pair : list) {
				temp.add(pair.node.val);
			}
			res.add(temp);
		}
		return res;
	}
	private class Pair {
		private TreeNode node;
		private int pos;
		private int depth;
		public Pair(TreeNode node, int pos, int depth) {
			this.node = node;
			this.pos = pos;
			this.depth = depth;
		}
	}
	private class myComparator implements Comparator<Pair> {
		public int compare(Pair p1, Pair p2) {
			if (p1.depth == p2.depth) {
				return p1.node.val - p2.node.val;
			}
			return 0;
		}
	}
}
