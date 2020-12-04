public class _875KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int H) {
		if (piles == null || piles.length == 0) return 0;
		int l = 1, r = 1000000000;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (check(piles, mid, H)) r = mid;
			else l = mid + 1;
		}
		return r;
	}

	private boolean check(int[] a, int speed, int limit) {
		int cnt = 0;
		for (int x : a) {
			if (x % speed == 0) cnt += x / speed;
			else cnt += x / speed + 1;
		}
		return cnt <= limit;
	}
}
