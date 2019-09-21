public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		if (s.length() == 0) {
			return true;
		}
		int cnt_a = 0;
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == 'A') {
				cnt_a++;
			}
			if (cnt_a >= 2) return false;
			if (c == 'L') {
				int j = i;
				int cnt_l = 0;
				while (j < s.length() && s.charAt(j) == 'L') {
					cnt_l++;
					j++;
				}
				if (cnt_l >= 3) return false;
			}
			i++;
		}
		return true;
	}
}
