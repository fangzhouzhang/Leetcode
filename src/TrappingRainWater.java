import java.util.Stack;

public class TrappingRainWater {
	/**
	 * @param heights: a list of integers
	 * @return: a integer
	 * time: o(n) space: o(n)
	 */
	public int trapRainWater(int[] heights) {
		//corner case null length == 0
		if (heights == null) {
			return -1;
		}
		if (heights.length <= 1) {
			return 0;
		}
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		left[0] = heights[0];
		right[heights.length - 1] = heights[heights.length - 1];
		for (int i = 1; i < heights.length; i++) {
			left[i] = Math.max(left[i - 1], heights[i]);
		}
		for (int i = heights.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], heights[i]);
		}
		int sum = 0;
		int twoSideMax = 0;
		for (int i = 0; i < heights.length; i++) {
			twoSideMax = Math.min(left[i], right[i]);
			sum += twoSideMax - heights[i];
		}
		return sum;
	}

	public int trap(int[] height) {
		if (height.length <= 1) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int idx = 0;
		while (idx < height.length) {
			if (stack.isEmpty() || height[idx] <= height[stack.peek()]) {
				stack.push(idx++);
			} else {
				int low = height[stack.peek()];
				stack.pop();
				if (stack.size() == 0) {
					continue;
				}
				res += (Math.min(height[idx], height[stack.peek()]) - low) * (idx - stack.peek() - 1);
			}
		}
		return res;
	}
}
