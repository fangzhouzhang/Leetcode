public class _1482MinimumNumberofDaystoMakemBouquets {
	public int minDays(int[] bloomDay, int m, int k) {
		if (bloomDay == null || bloomDay.length == 0) return 0;
		int start = 0, end = 1000000000;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isValid(bloomDay, m, k, mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start > 1000000000 ? -1 : start;
	}

	private boolean isValid(int[] bloomDay, int m, int k, int mid) {
		int consequetive = 0;
		int bouquets = 0;
		int n = bloomDay.length;
		for (int i = 0; i < n; i++) {
			if (bloomDay[i] > mid) {
				consequetive = 0;
			} else {
				consequetive += 1;
				if (consequetive == k) {
					bouquets++;
					consequetive = 0;
				}
			}
		}
		return bouquets >= m;
	}
}
