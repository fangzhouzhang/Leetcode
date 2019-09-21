public class ReverseStringII {
	public String reverseStr(String s, int k) {
		char[] a = s.toCharArray();
		for (int i = 0; i < s.length(); i += 2 * k) {
			int m = i;
			int j = Math.min(m + k - 1, s.length() - 1);
			while (m < j) {
				char tmp = a[m];
				a[m++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}
}
