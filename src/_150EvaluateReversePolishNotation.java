import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) return 0;
		Stack<String> stack = new Stack<>();
		int res = 0;
		for (String t : tokens) {
			if (t.equals("+")) {
				int b = Integer.valueOf(stack.pop());
				int a = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(a + b));
			} else if (t.equals("-")) {
				int b = Integer.valueOf(stack.pop());
				int a = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(a - b));
			} else if (t.equals("*")) {
				int b = Integer.valueOf(stack.pop());
				int a = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(a * b));
			} else if (t.equals("/")) {
				int b = Integer.valueOf(stack.pop());
				int a = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(a / b));
			} else {
				stack.push(t);
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
