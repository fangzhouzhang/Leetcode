import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		if (nums.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int i = 0;
		while (i < nums.length) {
			while (i < nums.length && !stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				min = Math.min(min, stack.pop());
			}
			if (i < nums.length) stack.push(i++);
		}

		stack.clear();
		i = nums.length - 1;
		while (i >= 0) {
			while (i >= 0 && !stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				max = Math.max(max, stack.pop());
			}
			if (i >= 0) stack.push(i--);
		}
		if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) return 0;
		return max - min + 1;
	}
}
