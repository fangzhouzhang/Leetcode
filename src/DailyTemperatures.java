import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		if (T.length == 0) return res;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[stack.peek()] <= T[i])  stack.pop();
			res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return res;
	}
}
