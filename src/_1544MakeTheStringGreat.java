import java.util.Stack;

public class _1544MakeTheStringGreat {
	public String makeGood(String s) {
		if (s == null || s.length() == 0) return "";
		Stack<Character> stack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (idx == 0 || stack.isEmpty()) {
				stack.push(s.charAt(idx++));
			} else {
				char top = stack.peek();
				if (Math.abs(top - s.charAt(idx)) == 32) {
					stack.pop();
					idx++;
				} else {
					stack.push(s.charAt(idx++));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return new String(sb.reverse());
	}
}
