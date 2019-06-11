import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder.length == 0) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		int lower_bound = Integer.MIN_VALUE;
		for (int i = 0; i < preorder.length; i++) {
			if (preorder[i] <= lower_bound) {
				return false;
			}
			if (stack.isEmpty() || preorder[i] < stack.peek()) {
				stack.push(preorder[i]);
			} else if (preorder[i] >= stack.peek()) {
				while (!stack.isEmpty() && preorder[i] >= stack.peek()) {
					lower_bound = stack.pop();
				}
				stack.push(preorder[i]);
			}
		}
		return true;
	}
}
