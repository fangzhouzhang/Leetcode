import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorII {
	/**
	 * @param root: The root of the tree
	 * @param A: node in the tree
	 * @param B: node in the tree
	 * @return: The lowest common ancestor of A and B
	 * time: o(height) space: o(n)
	 */
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
		// write your code here
		if (root == null || root == A || root == B) {
			return root;//base case
		}
		Set<ParentTreeNode> set = new HashSet<>();
		while (A != null) {
			set.add(A);
			A = A.parent;
		}
		while (B != null) {
			if (set.contains(B)) {
				return B;
			}
			B = B.parent;
		}
		return root;
	}

	private class ParentTreeNode {
		public ParentTreeNode parent, left, right;
	}
}
