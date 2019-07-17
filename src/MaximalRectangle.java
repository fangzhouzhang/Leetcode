import java.util.Stack;

public class MaximalRectangle {
	public int largestRectangleArea(int[] heights) {
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int rightBound = i;
				int heightIdx = stack.pop();
				int leftBound = getLeftBoundary(stack, heights[heightIdx], heights);
				max = Math.max(max, heights[heightIdx] * (rightBound - leftBound - 1));
			}
		}
		int rightMost = stack.peek() + 1;
		while (!stack.isEmpty()) {
			int heightIdx = stack.pop();
			int leftBound = getLeftBoundary(stack, heights[heightIdx], heights);
			max = Math.max(max, heights[heightIdx] * (rightMost - leftBound - 1));
		}
		return max;
	}
	private int getLeftBoundary(Stack<Integer> stack, int h, int[] heights) {
		while (!stack.isEmpty() && h == heights[stack.peek()]) {
			stack.pop();
		}
		return stack.isEmpty() ? -1 : stack.peek();
	}
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int[] heights = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					heights[j] = 0;
				} else {
					heights[j] = heights[j] + 1;
				}
			}
			max = Math.max(max, largestRectangleArea(heights));
		}
		return max;
	}
}
