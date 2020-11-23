import java.util.Stack;

public class _84LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) return 0;
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			// strictly <, otherwise area will be less. example [1, 1]
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
			if (stack.isEmpty()) left[i] = -1;
			else left[i] = stack.peek();
			stack.push(i);
		}
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
			if (stack.isEmpty()) right[i] = n;
			else right[i] = stack.peek();
			stack.push(i);
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
		}
		return res;
	}
}
