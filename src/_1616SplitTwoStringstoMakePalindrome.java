public class _1616SplitTwoStringstoMakePalindrome {
	public boolean checkPalindromeFormation(String a, String b) {
		if (a == null || b == null) return false;
		int s1 = 0, n = a.length(), e1 = n - 1;
		int s2 = 0, e2 = n - 1;
		while (s1 <= e1 && a.charAt(s1) == b.charAt(e1)) {
			s1++;
			e1--;
		}
		while (s2 <= e2 && b.charAt(s2) == a.charAt(e2)) {
			s2++;
			e2--;
		}
		int start = 0, end = n - 1;
		if (e2 - s2 > e1 - s1) {
			start = s1;
			end = e1;
		} else {
			start = s2;
			end = e2;
		}
		if (start > end) return true;
		boolean p = true;
		for (int i = start, j = end; i < j; i++, j--) {
			if (a.charAt(i) != a.charAt(j)) {
				p = false;
				break;
			}
		}
		if (p) return true;
		p = true;
		for (int i = start, j = end; i < j; i++, j--) {
			if (b.charAt(i) != b.charAt(j)) {
				p = false;
				break;
			}
		}
		if (p) return true;
		return false;
	}
}
