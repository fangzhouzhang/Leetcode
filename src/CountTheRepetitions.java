public class CountTheRepetitions {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int count1 = 0;
		int count2 = 0;
		int i1 = 0, i2 = 0;
		while (count1 < n1) {
			if (s1.charAt(i1) == s2.charAt(i2)) {
				i2++;
			}
			i1++;
			if (i2 == s2.length()) {
				count2++;
				i2 = 0;
			}
			if (i1 == s1.length()) {
				count1++;
				i1 = 0;
			}
		}
		return count2 / n2;
	}
}
