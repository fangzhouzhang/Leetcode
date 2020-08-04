import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _314BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		q.add(new Pair(root, 0));
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				int pos = p.pos;
				min = Math.min(min, pos);
				max = Math.max(max, pos);
				if (!map.containsKey(pos)) map.put(pos, new ArrayList<>());
				map.get(pos).add(p.node.val);
				if (p.node.left != null) {
					q.add(new Pair(p.node.left, pos - 1));
				}
				if (p.node.right != null) {
					q.add(new Pair(p.node.right, pos + 1));
				}
			}
		}
		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		return res;
	}

	private class Pair{
		TreeNode node;
		int pos;
		public Pair(TreeNode node, int pos) {
			this.node = node;
			this.pos = pos;
		}
	}
}
