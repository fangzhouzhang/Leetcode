import java.util.Stack;

public class LongestValidParentheses {
	/**
	 * https://leetcode.com/articles/longest-valid-parentheses/
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if (s.length() == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			}
			if (ch == ')') {
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						stack.push(i);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		return max;
	}
}
