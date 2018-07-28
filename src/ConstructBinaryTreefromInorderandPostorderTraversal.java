import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	/**
	 * @param inorder: A list of integers that inorder traversal of a tree
	 * @param postorder: A list of integers that postorder traversal of a tree
	 * @return: Root of a tree
	 * time: o(n)
	 * space: call stack o(h)
	 * 			map o(n)
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// write your code here
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			idxMap.put(inorder[i], i);
		}
		return construct(postorder, 0, postorder.length - 1,
				inorder, 0, inorder.length - 1,
				idxMap);
	}
	public TreeNode construct(int[] postorder, int post_l, int post_r,
							  int[] inorder, int in_l, int in_r,
							  Map<Integer, Integer> idxMap) {
		if (in_l > in_r) {
			return null;
		}
        /*if (pre_l > pre_r) {
            return null;
        }*/
		TreeNode root = new TreeNode(postorder[post_r]);
		int leftSize = idxMap.get(postorder[post_r]) - in_l;
		root.left = construct(postorder, post_l, post_l + leftSize - 1,
				inorder, in_l, in_l + leftSize - 1,
				idxMap);
		root.right = construct(postorder, post_l + leftSize, post_r - 1,
				inorder, in_l + leftSize + 1, in_r,
				idxMap);
		return root;
	}
}
