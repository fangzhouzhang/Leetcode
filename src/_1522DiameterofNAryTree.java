import java.util.ArrayList;
import java.util.List;

public class _1522DiameterofNAryTree {
	public int diameter(Node root) {
		if (root == null) return 0;
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}

	private int dfs(Node root, int[] res) {
		if (root == null) return 0;
		int curMax = 0;
		int n = root.children.size();
		int m1 = 0, m2 = 0;
		for (int i = 0; i < n; i++) {
			int v1 = dfs(root.children.get(i), res);
			if (v1 > m1) {
				m2 = m1;
				m1 = v1;
			} else if (v1 > m2) {
				m2 = v1;
			}
		}
		res[0] = Math.max(res[0], m1 + m2);
		return Math.max(m1, m2) + 1;
	}
	private class Node {
		public int val;
		public List<Node> children;


		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val,ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
