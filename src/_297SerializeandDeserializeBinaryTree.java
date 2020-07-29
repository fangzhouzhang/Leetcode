public class _297SerializeandDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		dfs(root, sb);
		return new String(sb);
	}

	private void dfs(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null").append(",");
			return;
		}
		sb.append(root.val).append(",");
		dfs(root.left, sb);
		dfs(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) return null;
		int[] idx = new int[1];
		return helper(data.split(","), idx);
	}

	private TreeNode helper(String[] data, int[] idx) {
		if (data.length == idx[0] || data[idx[0]].equals("null")) return null;
		TreeNode root = new TreeNode(Integer.valueOf(data[idx[0]]));
		idx[0]++;
		root.left = helper(data, idx);
		idx[0]++;
		root.right = helper(data, idx);
		return root;
	}
}
