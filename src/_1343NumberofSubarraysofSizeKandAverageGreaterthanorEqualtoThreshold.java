public class _1343NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		if (arr == null || arr.length == 0) return 0;
		int n = arr.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			prefix[i + 1] = sum;
		}
		int res = 0;
		//y = k + i - 1
		for (int i = 0; k + i < prefix.length; i++) {
			if (prefix[k + i] - prefix[i] >= k * threshold) res++;
		}
		return res;
	}
}
