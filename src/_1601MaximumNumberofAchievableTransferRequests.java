public class _1601MaximumNumberofAchievableTransferRequests {
	int max = 0;
	public int maximumRequests(int n, int[][] requests) {
		if (requests == null || requests.length == 0) return 0;
		dfs(0, new int[n], requests, 0);
		return max;
	}

	private void dfs(int idx, int[] count, int[][] requests, int cur) {
		if (idx == requests.length) {
			for (int n : count) {
				if (n != 0) return;
			}
			max = Math.max(max, cur);
			return;
		}

		// switch
		count[requests[idx][0]]--;
		count[requests[idx][1]]++;
		dfs(idx + 1, count, requests, cur + 1);
		count[requests[idx][0]]++;
		count[requests[idx][1]]--;
		// not switch
		dfs(idx + 1, count, requests, cur);
	}
}
