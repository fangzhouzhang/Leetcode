import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+")) {
				int second = Integer.parseInt(stack.pop());
				int first = Integer.parseInt(stack.pop());
				int cur = first + second;
				stack.push(cur + "");
			} else if (token.equals("-")) {
				int second = Integer.parseInt(stack.pop());
				int first = Integer.parseInt(stack.pop());
				int cur = first - second;
				stack.push(cur + "");
			} else if (token.equals("*")) {
				int second = Integer.parseInt(stack.pop());
				int first = Integer.parseInt(stack.pop());
				int cur = first * second;
				stack.push(cur + "");
			} else if (token.equals("/")) {
				int second = Integer.parseInt(stack.pop());
				int first = Integer.parseInt(stack.pop());
				int cur = first / second;
				stack.push(cur + "");
			} else {
				stack.push(token);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
