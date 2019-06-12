import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i <= heights.length; i++) {
			int currentHeight = i < heights.length ? heights[i] : 0;
			while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
				int h = heights[stack.pop()];
				int s = h * (stack.isEmpty() ? i :  i - stack.peek() - 1);
				max = Math.max(max, s);
			}
			stack.push(i);
		}
		return max;
	}
}
