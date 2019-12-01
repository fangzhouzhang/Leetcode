import java.util.Stack;

public class _739DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0) return T;
		int[] res = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		while (idx < T.length) {
			if (stack.isEmpty() || T[stack.peek()] >= T[idx]) stack.push(idx++);
			else {
				int largerTempIdx = stack.pop();
				res[largerTempIdx] = idx - largerTempIdx;
			}
		}
		return res;
	}
}
