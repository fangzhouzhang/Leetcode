import java.util.Stack;

public class _85MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int[] heights = new int[matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '0') heights[j] = 0;
				else heights[j] += 1;
			}
			max = Math.max(max, getRect(heights));
		}
		return max;
	}

	private int getRect(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		int idx = 0;
		while (idx < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[idx]) stack.push(idx++);
			else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? idx : idx - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
		}
		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int w = stack.isEmpty() ? idx : idx - stack.peek() - 1;
			max = Math.max(max, h * w);
		}
		return max;
	}
}
