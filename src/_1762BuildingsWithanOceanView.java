import java.util.Stack;

public class _1762BuildingsWithanOceanView {
	public int[] findBuildings(int[] heights) {
		if (heights == null || heights.length == 0) return new int[0];
		int n = heights.length;
		int max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			if (heights[i] > max) {
				stack.add(i);
				max = Math.max(max, heights[i]);
			}
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = stack.pop();
		}
		return res;
	}
}
