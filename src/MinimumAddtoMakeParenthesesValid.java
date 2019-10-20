public class MinimumAddtoMakeParenthesesValid {
	public int minAddToMakeValid(String S) {
		int l = 0;
		int i = 0;
		int r = 0;
		while (i < S.length()) {
			char c = S.charAt(i);
			if (c == '(') l++;
			else if (c == ')' && l > 0) l--;
			else if (c == ')' && l == 0) r++;
			i++;
		}
		return l + r;
	}
}
