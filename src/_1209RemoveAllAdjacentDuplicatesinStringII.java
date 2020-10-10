import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesinStringII {
	public String removeDuplicates(String s, int k) {
		if (s == null || s.length() == 0) return "";
		Stack<StringBuilder> stack = new Stack<>();
		int idx = 0, n = s.length();
		while (idx < n) {
			char c = s.charAt(idx);
			if (stack.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				sb.append(c);
				stack.push(sb);
			} else {
				StringBuilder lastSb = stack.peek();
				if (lastSb.charAt(0) == c) {
					if (lastSb.length() + 1 == k) {
						stack.pop();
					} else {
						lastSb.append(c);
					}
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(c);
					stack.push(sb);
				}
			}
			idx++;
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return new String(res.reverse());
	}
}
