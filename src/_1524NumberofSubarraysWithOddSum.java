public class _1524NumberofSubarraysWithOddSum {
	private int M = 1000000007;
	public int numOfSubarrays(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		int res = 0, odd = 0, even = 0;
		if (arr[0] % 2 == 0) {
			even = 1;
		} else {
			odd = 1;
			res += odd;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even += 1;
			} else {
				int tmp = odd;
				odd = even + 1;
				even = tmp;
			}
			res = (res + odd) % M;
		}
		return res;
	}
}
