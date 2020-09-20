public class _1588SumofAllOddLengthSubarrays {
	public int sumOddLengthSubarrays(int[] arr) {
		int n = arr.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			prefix[i + 1] = sum;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if ((j - i + 1 )% 2 == 1) {
					res += prefix[j + 1] - prefix[i];
				}
			}
		}
		return res;
	}
}
