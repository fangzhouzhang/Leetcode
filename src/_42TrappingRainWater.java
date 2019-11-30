import java.util.Stack;

public class _42TrappingRainWater {
	/**
	 * @param height: a list of integers
	 * @return: a integer
	 * time: o(n) space: o(n)
	 */
	public int trap(int[] height) {
		if (height == null || height.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int idx = 0, res = 0;
		while (idx < height.length) {
			if (stack.isEmpty() || height[stack.peek()] >= height[idx]) stack.push(idx++);
			else {
				int low = height[stack.pop()];
				if (stack.isEmpty()) continue;
				int high = Math.min(height[stack.peek()], height[idx]);
				res += (high - low) * (idx - stack.peek() - 1);
			}
		}
		return res;
	}
}
