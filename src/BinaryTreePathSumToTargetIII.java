import java.util.HashSet;
import java.util.Set;

public class BinaryTreePathSumToTargetIII {
	/**
	 *
	 * @param root root of subtree
	 * @param target
	 * @return whether from one node to another, path sum equals to target
	 * time: o(n)
	 * space: call stack o(h)
	 * 			o(n) set
	 */
	public boolean exist(TreeNode root, int target) {
		// Write your solution here
		boolean[] hasFind = {false};
		Set<Integer> prefixSum = new HashSet<Integer>();
		prefixSum.add(0);
		isExist(root, prefixSum, hasFind, target, 0);
		return hasFind[0];
	}
	public void isExist(TreeNode root, Set<Integer> prefixSum, boolean[] hasFind, int target, int sum) {
		if (root == null || hasFind[0] == true) {
			return;
		}
		int temp = sum + root.val - target;
		if (prefixSum.contains(temp)) {
			hasFind[0] = true;
			return;
		}
		boolean isDuplicatePrefixSum = prefixSum.contains(sum + root.val);
		if (!isDuplicatePrefixSum) {
			prefixSum.add(sum + root.val);
		}
		isExist(root.left, prefixSum, hasFind, target, sum + root.val);
		isExist(root.right, prefixSum, hasFind, target, sum + root.val);
		if (!isDuplicatePrefixSum) {
			prefixSum.remove(sum + root.val);
		}
	}
}
