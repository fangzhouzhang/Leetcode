public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int end = s.length() - 1;
		int start = s.length() - 1;
		while (end >= 0) {
			if (!Character.isLetter(s.charAt(end))) {
				end--;
			} else {
				break;
			}
		}
		int len = 0;
		while (end >= 0) {
			if (Character.isLetter(s.charAt(end))) {
				len++;
				end--;
			} else {
				break;
			}
		}
		return len;
	}
}
