import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	/**
	 * @param inorder: A list of integers that inorder traversal of a tree
	 * @param preorder: A list of integers that postorder traversal of a tree
	 * @return: Root of a tree
	 * time: o(n)
	 * space: call stack o(h)
	 * 			map o(n)
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// write your code here
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			idxMap.put(inorder[i], i);
		}
		return construct(preorder, 0, preorder.length - 1,
				inorder, 0, inorder.length - 1,
				idxMap);
	}
	public TreeNode construct(int[] preorder, int pre_l, int pre_r,
							  int[] inorder, int in_l, int in_r,
							  Map<Integer, Integer> idxMap) {
        /*if (in_l > in_r)                             {
            return null;
        }*/
		if (pre_l > pre_r)                             {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pre_l]);
		int leftSize = idxMap.get(preorder[pre_l]) - in_l;
		root.left = construct(preorder, pre_l + 1, pre_l + leftSize,
				inorder, in_l, in_l + leftSize - 1,
				idxMap);
		root.right = construct(preorder, pre_l + leftSize + 1, pre_r,
				inorder, in_l + leftSize + 1, in_r,
				idxMap);
		return root;
	}
}
