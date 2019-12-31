public class _551StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		if (s == null || s.length() == 0) return false;
		int idx = 0, count = 0;
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (c == 'A') {
				count++;
				if (count == 2) return false;
			}
			else if (c == 'L') {
				if (idx + 2 < s.length() && s.charAt(idx + 1) == 'L' && s.charAt(idx + 2) == 'L') return false;
			}
			idx++;
		}
		return true;
	}
}
