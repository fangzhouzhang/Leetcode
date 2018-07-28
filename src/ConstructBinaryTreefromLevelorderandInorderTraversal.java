import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromLevelorderandInorderTraversal {
	/**
	 * @param inOrder: A list of integers that inorder traversal of a tree
	 * @param levelOrder: A list of integers that levelOrder traversal of a tree
	 * @return: Root of a tree
	 * time: o(n * h)
	 * space: call stack o(h)
	 * 			map o(n)
	 */
	public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
		// Write your solution here
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			idxMap.put(inOrder[i], i);
		}
		return construct(levelOrder,
				inOrder, 0, inOrder.length - 1,
				idxMap);
	}
	public TreeNode construct(int[] level,
							  int[] in, int in_l, int in_r,
							  Map<Integer, Integer> idxMap) {
		if (in_l > in_r || level.length < 1) {
			return null;
		}
		TreeNode root = new TreeNode(level[0]);
		int rootIdx = idxMap.get(level[0]);
		int leftSize = rootIdx - in_l;
		int rightSize = in_r - rootIdx;
		int[] levelLeft = new int[leftSize];
		int[] levelRight = new int[rightSize];
		int j = 0;
		int k = 0;
		for (int i = 1; i < level.length; i++) {
			if (j < leftSize && idxMap.get(level[i]) < rootIdx) {
				levelLeft[j++] = level[i];
			} else if (k < rightSize && idxMap.get(level[i]) > rootIdx){
				levelRight[k++] = level[i];
			}
		}
		root.left = construct(levelLeft,
				in, in_l, in_l + leftSize - 1,
				idxMap);
		root.right = construct(levelRight,
				in, in_l + leftSize + 1, in_r,
				idxMap);
		return root;
	}
	/*@Test
	public void testReconstruct() {
		*//*int[] level = {10,5,15,2,7,12,20};
		int[] in = {2,5,7,10,12,15,20};*//*
		int[] level = {4,1,10,5,9,6,7};
		int[] in = {1,6,5,7,4,10,9};
		TreeNode node = reconstruct(in, level);
		printNode(node);
	}

	private void printNode(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.val);
		printNode(node.left);
		printNode(node.right);
	}*/
}
