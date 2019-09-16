import java.util.Stack;

public class _132Pattern {
	public boolean find132pattern(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int mid = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < mid) return true;
			while (!stack.isEmpty() && stack.peek() < nums[i]) {
				mid = Math.max(mid, stack.pop());
			}
			stack.push(nums[i]);
		}
		return false;
	}
}
