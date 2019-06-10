import java.util.Stack;

public class TernaryExpressionParser {
	public String parseTernary(String expression) {
		if (expression.length() == 0) {
			return "";
		}
		Stack<String> stack = new Stack<>();
		int i = expression.length() - 1;
		while (i >= 0) {
			char c = expression.charAt(i);
			if (c == '(' || c == ')' || c == ':') {
				i--;
			} else if (c == '?') {
				i--;
				char symbol = expression.charAt(i);
				String t = stack.pop();
				String f = stack.pop();
				if (symbol == 'T') {
					stack.push(t);
				} else {
					stack.push(f);
				}
				i--;
			} else {
				StringBuilder sb = new StringBuilder();
				while (i >= 0 && expression.charAt(i) != '(' &&
						expression.charAt(i) != ')' &&
						expression.charAt(i) != ':' &&
						expression.charAt(i) != '?') {
					sb.append(expression.charAt(i));
					i--;
				}
				sb.reverse();
				stack.push(new String(sb));
			}
		}
		return stack.peek();
	}
}
