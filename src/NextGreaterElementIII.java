public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
		char[] a = ("" + n).toCharArray();
		int i = a.length - 2;
		while (i >= 0) {
			if (a[i] < a[i + 1]) {
				break;
			}
			i--;
		}
		if (i == -1) return -1;
		int j = a.length - 1;
		while (j >= 0) {
			if (a[i] < a[j]) {
				break;
			}
			j--;
		}
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		int m = i + 1;
		j = a.length - 1;
		while (m < j) {
			char t = a[m];
			a[m++] = a[j];
			a[j--] = t;
		}

		try {
			return Integer.parseInt(new String(a));
		} catch (Exception e) {
			return -1;
		}
	}
}
