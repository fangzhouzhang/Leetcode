public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		if (s.length() == 0) {
			return false;
		}
		int n = s.length();
		for (int i = n / 2; i >= 1; i--) {
			if (n % i == 0) {
				int m = n / i;
				StringBuilder sb = new StringBuilder();
				String str = s.substring(0, i);
				for (int j = 0; j < m; j++) {
					sb.append(str);
				}
				if (s.equals(new String(sb))) {
					return true;
				}
			}
		}
		return false;
	}
}
