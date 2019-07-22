public class ValidNumber {
	public boolean isNumber(String s) {
		if (s.length() == 0) {
			return true;
		}
		s = s.trim();
		boolean numSeen = false;
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numAfterE = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				numSeen = true;
				numAfterE = true;
			} else if (c == '.') {
				if (pointSeen || eSeen) {
					return false;
				}
				pointSeen = true;
			} else if (c == 'e') {
				if (eSeen || !numSeen) {
					return false;
				}
				numAfterE = false;
				eSeen = true;
			} else if (c == '-' || c =='+') {
				if (i > 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}
		return numSeen && numAfterE;
	}
}
