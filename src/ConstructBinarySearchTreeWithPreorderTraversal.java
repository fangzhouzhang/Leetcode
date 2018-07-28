import java.util.ArrayList;
import java.util.List;

public class ConstructBinarySearchTreeWithPreorderTraversal {
	/**
	 *
	 * @param pre number stored in preorder way
	 * @return root of whole tree
	 * time: o(n * h)
	 * space: call stack o(h)
	 * 			list o(n)
	 */
	public TreeNode reconstruct(int[] pre) {
		// Write your solution here
		List<Integer> preorder = new ArrayList<>();
		for (int i = 0; i < pre.length; i++) {
			preorder.add(pre[i]);
		}
		return construct(preorder);
	}
	public TreeNode construct(List<Integer> pre) {
		if (pre.size() == 0) {
			return null;
		}
		int rootVal = pre.get(0);
		TreeNode root = new TreeNode(rootVal);
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 1; i < pre.size(); i++) {
			if (pre.get(i) < rootVal) {
				left.add(pre.get(i));
			} else {
				right.add(pre.get(i));
			}
		}
		root.left = construct(left);
		root.right = construct(right);
		return root;
	}
}
