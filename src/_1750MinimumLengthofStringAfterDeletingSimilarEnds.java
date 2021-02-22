public class _1750MinimumLengthofStringAfterDeletingSimilarEnds {
	public int minimumLength(String s) {
		if (s == null || s.length() == 0) return 0;
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) break;
			while (l + 1 < r && s.charAt(l) == s.charAt(l + 1)) l++;
			while (l < r - 1 && s.charAt(r) == s.charAt(r - 1)) r--;
			l++;
			r--;
		}
		return r - l + 1;
	}
}
