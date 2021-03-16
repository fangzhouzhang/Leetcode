import java.util.Stack;

public class _1793MaximumScoreofaGoodSubarray {
	public int maximumScore(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			// strictly <, otherwise area will be less. example [1, 1]
			while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
			if (stack.isEmpty()) left[i] = -1;
			else left[i] = stack.peek();
			stack.push(i);
		}
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
			if (stack.isEmpty()) right[i] = n;
			else right[i] = stack.peek();
			stack.push(i);
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (k >= left[i] + 1 && k <= right[i] - 1)
				res = Math.max(res, nums[i] * (right[i] - left[i] - 1));
		}
		return res;
	}
}
