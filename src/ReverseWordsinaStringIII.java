public class ReverseWordsinaStringIII {
	public String reverseWords(String s) {
		if (s.length() == 0) return "";
		char[] c = s.toCharArray();
		reverse(c, 0, c.length - 1);
		String[] a = new String(c).split(" ");
		reverse(a);
		StringBuilder sb = new StringBuilder();
		for (String str: a) {
			sb.append(str).append(" ");
		}
		return new String(sb.deleteCharAt(sb.length() - 1));
	}

	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char c = a[i];
			a[i++] = a[j];
			a[j--] = c;
		}
	}
	private void reverse(String[] a) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			String c = a[i];
			a[i++] = a[j];
			a[j--] = c;
		}
	}
}
