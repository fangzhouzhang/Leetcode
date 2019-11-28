public class _392IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s == null || t == null) return false;
		if (s.length() == 0 && t.length() == 0) return true;
		int i = 0, j = 0;
		while (j < t.length()) {
			if (i < s.length() && s.charAt(i) == t.charAt(j)) i++;
			j++;
			if (i == s.length()) return true;
		}
		return false;
	}
}
