import java.util.Stack;

public class _20ValidParentheses {
	/**
	 * n is length of string
	 * time: o(n), space: o(n)
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.size() == 0 || stack.pop() != '(') {
					return false;
				}
			} else if (s.charAt(i) == '}') {
				if (stack.size() == 0 || stack.pop() != '{') {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (stack.size() == 0 || stack.pop() != '[') {
					return false;
				}
			}
		}
		return stack.size() == 0;
	}
}
