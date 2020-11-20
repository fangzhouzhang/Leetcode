public class _1612CheckIfTwoExpressionTreesareEquivalent {
	public boolean checkEquivalence(Node root1, Node root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null || root2 == null) return false;
		int[] a  = new int[26];
		int[] b  = new int[26];
		dfs(root1, a);
		dfs(root2, b);
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i]) return false;
		}
		return true;
	}

	private void dfs(Node root, int[] a) {
		if (root == null) return;
		if (root.val != '+') {
			int idx = (int)(root.val - 'a');
			a[idx]++;
		}
		dfs(root.left, a);
		dfs(root.right, a);
	}

	 private class Node {
		char val;
		Node left;
		Node right;
		Node() {this.val = ' ';}
		Node(char val) { this.val = val; }
		Node(char val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
