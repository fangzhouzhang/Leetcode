public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s.length() == 0 && t.length() == 0) {
			return false;
		}
		if (s.length() < t.length()) {
			String tmp = s;
			s = t;
			t = tmp;
		}
		if (s.length() - t.length() >= 2) {
			return false;
		}
		else if (s.length() - t.length() == 1) {
			int diff = 0;
			for (int i = 0; i < t.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					if (!s.substring(i + 1).equals(t.substring(i))) {
						return false;
					}
				}
			}
			return true;
		}
		else {
			int diff = 0;
			for (int i = 0; i < t.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					diff++;
				}
			}
			return diff == 1;
		}
	}
}
