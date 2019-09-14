public class NumberofSegmentsinaString {
	public int countSegments(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int res = 0;
		int idx = 0;
		while (idx < s.length()) {
			if (s.charAt(idx++) == ' ') {
				continue;
			}
			res++;
			while (idx < s.length() && s.charAt(idx) != ' ') {
				idx++;
			}
		}
		return res;
	}
}
