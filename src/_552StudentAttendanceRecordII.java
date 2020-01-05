public class _552StudentAttendanceRecordII {
	//a00 means A never appears, ending with 0 continous L
	//a01 means A never appears, ending with 1 continous L
	//a02 means A never appears, ending with 2 continous L
	//a10 means A appears once, ending with 0 continous L
	//a11 means A appears once, ending with 1 continous L
	//a12 means A appears once, ending with 2 continous L
	public int checkRecord(int n) {
		if (n <= 0) return 0;
		long m = 1000000007;
		long[] a00 = new long[n + 1];
		long[] a01 = new long[n + 1];
		long[] a02 = new long[n + 1];
		long[] a10 = new long[n + 1];
		long[] a11 = new long[n + 1];
		long[] a12 = new long[n + 1];
		a00[0] = 1;
		for (int i = 1; i <= n; i++) {
			a00[i] = (a00[i - 1] + a01[i - 1] + a02[i - 1]) % m;//a00'P' 01'P 02'P
			a01[i] = a00[i - 1];//a00'L'
			a02[i] = a01[i - 1];//a01'L'
			a10[i] = (a00[i - 1] + a01[i - 1] + a02[i - 1] + a10[i - 1] + a11[i - 1] + a12[i - 1]) % m;//00'a' 01'a' 02'a' 10'p' 11'p' 12'p
			a11[i] = a10[i - 1];//a10'L'
			a12[i] = a11[i - 1];//a11'L'
		}
		int res = (int)((a00[n] + a01[n] + a02[n] + a10[n] + a11[n] + a12[n]) % m);
		return res;
	}
}
