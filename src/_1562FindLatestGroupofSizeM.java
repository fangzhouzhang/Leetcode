public class _1562FindLatestGroupofSizeM {
	public int findLatestStep(int[] arr, int m) {
		if (arr == null || arr.length == 0) return 0;
		int n = arr.length;
		//longest[i] means the longest length of 1's group based on i-th end
		int[] longest = new int[n + 2];
		//lenCount[i] means that how many length i is
		int[] lenCount = new int[n + 1];
		int res = -1;
		for (int i = 0; i < n; i++) {
			int l = longest[arr[i] - 1];
			int r = longest[arr[i] + 1];
			int t = l + r + 1;
			longest[arr[i] - l] = longest[arr[i] + r] = t;
			longest[arr[i]] = t;
			lenCount[l]--;
			lenCount[r]--;
			lenCount[t]++;
			if (lenCount[m] > 0) res = i + 1;
		}
		return res;
	}
}
