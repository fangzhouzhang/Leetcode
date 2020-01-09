public class _777SwapAdjacentinLRString {
	public boolean canTransform(String start, String end) {
		if (start == null && end == null) return true;
		if (start == null || end == null) return false;
		if (start.length() != end.length()) return false;
		int startL = 0, startR = 0, endL = 0, endR = 0;
		for (int k = 0; k < start.length(); k++) {
			char a = start.charAt(k);
			char b = end.charAt(k);
			if (a == 'L') startL++;
			if (a == 'R') startR++;
			if (b == 'L') endL++;
			if (b == 'R') endR++;
		}
		if (startL != endL || startR != endR) return false;
		int i = 0, j = 0;
		while (i < start.length() && j < end.length()) {
			char a = start.charAt(i);
			char b = end.charAt(j);
			if ((a == 'X' && b == 'X') || (a == 'L' && b == 'L' && i >= j) || (a == 'R' && b == 'R' && i <= j)) {
				i++;
				j++;
			} else if ((a == 'X' && b == 'L') || (a == 'X' && b == 'R')) {
				i++;
			} else if ((a == 'L' && b == 'X') || (a == 'R' && b == 'X')) {
				j++;
			} else {
				return false;
			}
		}
		return true;
	}
}
