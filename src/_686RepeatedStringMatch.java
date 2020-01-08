public class _686RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		if (A == null || B == null) return -1;
		int repeat = 1;
		StringBuilder sb = new StringBuilder(A);
		while (sb.length() < B.length()) {
			sb.append(A);
			repeat++;
		}
		if (sb.indexOf(B) != -1) return repeat;
		sb.append(A);
		repeat++;
		if (sb.indexOf(B) != -1) return repeat;
		return -1;
	}
}
