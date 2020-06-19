import java.util.HashMap;
import java.util.Map;

public class _1485CloneBinaryTreeWithRandomPointer {

	public NodeCopy copyRandomBinaryTree(Node root) {
		if (root == null) return null;
		Map<Node, NodeCopy> map = new HashMap<>();
		dfs(map, root);
		for (Map.Entry<Node, NodeCopy> e : map.entrySet()) {
			Node origin = e.getKey();
			NodeCopy copy = e.getValue();
			copy.left = map.get(origin.left);
			copy.right = map.get(origin.right);
			copy.random = map.get(origin.random);
		}
		return map.get(root);
	}

	private void dfs(Map<Node, NodeCopy> map, Node root) {
		if (root == null) return;
		dfs(map, root.left);
		map.put(root, new NodeCopy(root.val));
		dfs(map, root.right);
	}


	private class Node {
		int val;
		Node left;
		Node right;
		Node random;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node left, Node right, Node random) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.random = random;
		}
	}

	private class NodeCopy {
		int val;
		NodeCopy left;
		NodeCopy right;
		NodeCopy random;

		NodeCopy() {
		}

		NodeCopy(int val) {
			this.val = val;
		}

		NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.random = random;
		}
	}
}
