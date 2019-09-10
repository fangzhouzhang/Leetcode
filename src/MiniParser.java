import java.util.Stack;

public class MiniParser {
	public NestedInteger deserialize(String s) {
		if (!s.startsWith("[")) {
			return new NestedInteger(Integer.valueOf(s));
		}
		Stack<NestedInteger> stack = new Stack<>();
		int start = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				stack.push(new NestedInteger());
				start = i + 1;
			} else if (s.charAt(i) == ']' || s.charAt(i) == ',') {
				if (i > start) {
					stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(start, i))));
				}
				start = i + 1;
				if (s.charAt(i) == ']') {
					if (stack.size() > 1) {
						NestedInteger ni = stack.peek();
						stack.pop();
						stack.peek().add(ni);
					}
				}
			}
		}
		return stack.peek();
	}

	private class NestedInteger {

		public NestedInteger(int num) {

		}

		public boolean isInteger() {
			return false;
		}

		public int getInteger() {
			return 0;
		}

		public void add(NestedInteger ni) {

		}

	}
}
