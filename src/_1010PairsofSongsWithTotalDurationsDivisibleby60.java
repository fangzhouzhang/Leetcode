public class _1010PairsofSongsWithTotalDurationsDivisibleby60 {
	public int numPairsDivisibleBy60(int[] time) {
		if (time == null || time.length == 0) return 0;
		int[] map = new int[60];
		int res = 0;
		for (int x : time) {
			if (x % 60 == 0) res += map[0];
			else res += map[60 - (x % 60)];
			int idx = x % 60 == 0 ? 0 : x % 60;
			map[idx]++;
		}
		return res;
	}
}
