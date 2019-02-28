import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeNaryTree {
	public String serialize(Node root) {
		if (root == null) {
			return "#";
		}
		StringBuilder sb = new StringBuilder();
		dfs(sb, root);
		return sb.toString();
	}

	private void dfs(StringBuilder sb, Node root) {

		sb.append(root.val);
		sb.append(",");
		sb.append(root.children.size());
		sb.append(",");
		for (Node n: root.children) {
			dfs(sb, n);
		}
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data.equals("#")) {
			return null;
		}
		String[] nums = data.split(",");
		Queue<String> q = new LinkedList<>();
		for (String num: nums) {
			q.add(num);
		}
		return helper(q);
	}
	private Node helper(Queue<String> q) {
		int val = Integer.parseInt(q.poll());
		int size = Integer.parseInt(q.poll());

		List<Node> children = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			children.add(helper(q));
		}
		return new Node(val, children);
	}
	private class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
