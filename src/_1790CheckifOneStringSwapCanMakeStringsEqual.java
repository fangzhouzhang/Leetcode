public class _1790CheckifOneStringSwapCanMakeStringsEqual {
	public boolean areAlmostEqual(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		if (n != m) return false;
		int diff = 0, p1=-1, p2=-1;
		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
				if (p1 == -1) p1 = i;
				else p2 = i;
			}
			if (diff > 2) return false;
		}
		if (diff == 0) return true;
		if (diff == 2) {
			if (s1.charAt(p1) == s2.charAt(p2) && s1.charAt(p2) == s2.charAt(p1)) return true;
			return false;
		}
		return false;
	}
}
