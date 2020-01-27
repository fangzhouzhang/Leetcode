public class _65ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) return false;
		s = s.trim();
		int countE = 0, posE = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'e') {
				countE++;
				posE = i;
			} else if (Character.isLetter(c)) return false;
		}
		if (countE > 1) return false;
		if (posE == -1) return isNum(s, 1);
		return isNum(s.substring(0, posE), 1) && isNum(s.substring(posE + 1), 0);
	}

	private boolean isNum(String s, int decimalNum) {
		int countD = 0;
		boolean num = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '.') countD++;
			else if (Character.isDigit(c)) num = true;
			else if (i != 0 && !Character.isDigit(c)) return false;
		}
		return num && countD <= decimalNum;
	}
}
