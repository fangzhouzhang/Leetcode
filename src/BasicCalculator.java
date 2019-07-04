import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int sign = 1;
		int result = 0;
		int operand = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				operand = operand * 10 + c - '0';

			} else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				//reset
				result = 0;
				sign = 1;
			} else if (c == ')') {
				result += sign * operand;
				operand = 0;
				result *= stack.pop();
				result += stack.pop();
			} else if (c == '+') {
				result += sign * operand;

				operand = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * operand;

				operand = 0;
				sign = -1;
			}
		}
		return (result + sign * operand);
	}
}
