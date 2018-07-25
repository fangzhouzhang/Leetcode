public class LargestNumberSmallerInBinarySearchTree {
	/**
	 * input:treenode root and target
	 * output: largest number smaller than target
	 * time: o(log n) space: o(1)
	 */
	public int tempRes = Integer.MIN_VALUE;
	public int largestSmaller(TreeNode root, int target) {
		// Write your solution here
		if (root == null) {
			return tempRes;
		}
		//step1
		if (root.val >= target) {
			return largestSmaller(root.left, target);
		}
		else {//step 2
			tempRes = root.val;
			return largestSmaller(root.right, target);
		}
	}
}

