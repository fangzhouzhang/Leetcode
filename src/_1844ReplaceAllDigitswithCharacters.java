public class _1844ReplaceAllDigitswithCharacters {
	public String replaceDigits(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				char cur = (char)(s.charAt(i - 1) + c - '0');
				sb.append(cur);
			} else sb.append(c);
		}
		return new String(sb);
	}
}
