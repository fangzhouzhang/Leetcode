import java.util.Stack;

public class _1578MinimumDeletionCosttoAvoidRepeatingLetters {
	public int minCost(String s, int[] cost) {
		int idx = 0, n = s.length();
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		while (idx < n) {
			if (stack.isEmpty() || s.charAt(stack.peek()) != s.charAt(idx)) {
				stack.push(idx++);
			} else {
				if (cost[stack.peek()] < cost[idx]) {
					res += cost[stack.pop()];
				} else {
					res += cost[idx];
					idx++;
				}
			}
		}
		return res;
	}
}
