import java.util.Stack;

public class _739DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0) return new int[0];
		int n = T.length;
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[n];
		for (int i = n - 1, j = n - 1; i >= 0; i--, j--) {
			while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
			if (stack.isEmpty()) {
				res[j] = 0;
			} else {
				res[j] = stack.peek() - i;
			}
			stack.push(i);
		}
		return res;
	}
}
