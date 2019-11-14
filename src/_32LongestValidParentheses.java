import java.util.Stack;

public class _32LongestValidParentheses {
	/**
	 * https://leetcode.com/articles/longest-valid-parentheses/
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) stack.pop();
				if (stack.isEmpty()) stack.push(i);
					//stack.peek() means the last index which is not part of current parenthesis
				else max = Math.max(max, i - stack.peek());
			}
		}
		return max;
	}
}
