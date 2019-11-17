import java.util.Stack;

public class _439TernaryExpressionParser {
	public String parseTernary(String expression) {
		if (expression.length() == 0) return "";
		Stack<StringBuilder> sbStack = new Stack<>();
		sbStack.push(new StringBuilder());
		int i = expression.length() - 1;
		while (i >= 0) {
			if (expression.charAt(i) == ':') sbStack.push(new StringBuilder());
			else if (expression.charAt(i) == '?') {
				StringBuilder trueCan = sbStack.pop();
				StringBuilder falseCan = sbStack.pop();
				i--;
				if (expression.charAt(i) == 'T') {
					sbStack.push(trueCan);
				} else {
					sbStack.push(falseCan);
				}
			} else {
				sbStack.peek().append(expression.charAt(i));
			}
			i--;
		}
		return sbStack.peek().toString();
	}
}
