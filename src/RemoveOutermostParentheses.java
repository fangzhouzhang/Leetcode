public class RemoveOutermostParentheses {
	public String removeOuterParentheses(String S) {
		if (S == null || S.length() == 0) return "";
		StringBuilder sb = new StringBuilder();
		int open = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(' && open++ > 0) sb.append(c);
			if (c == ')' && open-- > 1) sb.append(c);
		}
		return new String(sb);
	}}
