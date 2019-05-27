public class RemoveAllAdjacentDuplicatesInString {
	public String removeDuplicates(String S) {
		int idx = 0;
		while (idx < S.length()) {
			if (idx < S.length() - 1 && S.charAt(idx) == S.charAt(idx + 1)) {
				S = eliminate(S, idx);
				idx = 0;
			} else {
				idx++;
			}

		}
		return S;
	}
	private String eliminate(String s, int idx) {
		int l = idx;
		int r = idx + 1;
		while (l >= 0 && r < s.length()) {
			if (s.charAt(l) != s.charAt(r)) {
				break;
			}
			l--;
			r++;

		}
		return s.substring(0, l + 1) + s.substring(r, s.length());
	}
}
