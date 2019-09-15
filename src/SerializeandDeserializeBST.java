import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBST {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return new String(sb);
	}

	private void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		sb.append(root.val).append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0) return null;
		String[] vals = data.split(",");
		Queue<String> q = new LinkedList<>();
		for (String val : vals) {
			q.offer(val);
		}
		return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode deserialize(Queue<String> q, int min, int max) {
		if (q.isEmpty()) return null;
		int val = Integer.valueOf(q.peek());
		if (val < min || val > max) return null;
		q.poll();
		TreeNode node = new TreeNode(val);
		node.left = deserialize(q, min, val);
		node.right = deserialize(q, val, max);
		return node;
	}
}
