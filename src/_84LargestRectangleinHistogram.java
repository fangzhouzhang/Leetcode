import java.util.Stack;

public class _84LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int max = -1;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i++);
			} else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
		}
		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h * w);
		}
		return max;
	}
}
