import java.util.Stack;

public class NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {
		if (nums.length == 0) {
			return new int[0];
		}
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[nums.length];
		int idx = 0;
		while (idx < 2) {
			for (int i = nums.length - 1; i >= 0; i--) {
				while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					res[i] = -1;
				} else {
					res[i] = nums[stack.peek()];
				}
				stack.push(i);
			}
			idx++;
		}
		return res;
	}
}
