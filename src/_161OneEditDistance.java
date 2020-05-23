public class _161OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) return false;
		if (Math.abs(s.length() - t.length()) > 1) return false;
		if (s.length() > t.length()) {
			String tmp = s;
			s = t;
			t = tmp;
		}
		int i = 0, j = 0;
		if (s.length() < t.length()) {
			if (s.length() == 0) return true;
			int cnt = 0;
			while (j < t.length()) {
				if (i < s.length() && s.charAt(i) == t.charAt(j)) {
					i++;
					j++;
				} else if (i == s.length() || s.charAt(i) != t.charAt(j)) {
					j++;
					cnt++;
				}
			}
			return cnt == 1;
		} else {
			int cnt = 0;
			while (i < s.length() && j < t.length()) {
				if (s.charAt(i) == t.charAt(j)) {
					i++;
					j++;
				} else {
					i++;
					j++;
					cnt++;
				}
			}
			return cnt == 1;
		}
	}
}
