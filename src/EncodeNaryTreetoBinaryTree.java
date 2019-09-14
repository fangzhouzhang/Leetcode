import java.util.ArrayList;
import java.util.List;

public class EncodeNaryTreetoBinaryTree {

	// Encodes an n-ary tree to a binary tree.
	public TreeNode encode(Node root) {
		if (root == null) {
			return null;
		}
		TreeNode cur = new TreeNode(root.val);
		if (root.children.size() > 0) {
			cur.left = encode(root.children.get(0));
		}
		TreeNode n = cur.left;
		for (int i = 1; i < root.children.size(); i++) {
			n.right = encode(root.children.get(i));
			n = n.right;
		}
		return cur;
	}

	// Decodes your binary tree to an n-ary tree.
	public Node decode(TreeNode root) {
		if (root == null) {
			return null;
		}
		Node cur = new Node(root.val, new ArrayList<Node>());
		TreeNode l = root.left;
		while (l != null) {
			cur.children.add(decode(l));
			l = l.right;
		}
		return cur;
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
