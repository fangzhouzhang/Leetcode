public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] a = new int[n];
		a[0] = 1;
		int i1 = 0, i2 = 0, i3 = 0;
		int cnt = 1;
		while (cnt < n) {
			a[cnt] = Math.min(a[i1] * 2, Math.min(a[i2] * 3, a[i3] * 5));
			if (a[cnt] == a[i1] * 2) {
				i1++;
			}
			if (a[cnt] == a[i2] * 3) {
				i2++;
			}
			if (a[cnt] == a[i3] * 5){
				i3++;
			}
			cnt++;
		}



		return a[n - 1];
	}
}
