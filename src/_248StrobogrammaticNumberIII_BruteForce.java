public class _248StrobogrammaticNumberIII_BruteForce {
	private long low = 0l;
	private long high = 0l;

	public int strobogrammaticInRange(String low, String high) {
		this.low = Long.valueOf(low);
		this.high = Long.valueOf(high);
		if (this.low > this.high) return 0;
		int[] res = new int[1];
		for (int i = low.length(); i <= high.length(); i++) {
			char[] tmp = new char[i];
			dfs(tmp, 0, i - 1, res);
		}
		return res[0];
	}

	private void dfs(char[] tmp, int start, int end, int[] res) {
		if (start > end) {
			long val = Long.valueOf(new String(tmp));
			if ((val < low) || (val > high)) return;
			res[0]++;
			return;
		}

		if ((start != 0 && start <= end) || (start == 0 && end == start)) {
			tmp[start] = '0';
			tmp[end] = '0';
			dfs(tmp, start + 1, end - 1, res);
		}

		tmp[start] = '1';
		tmp[end] = '1';
		dfs(tmp, start + 1, end - 1, res);

		if (start < end) {
			tmp[start] = '6';
			tmp[end] = '9';
			dfs(tmp, start + 1, end - 1, res);
		}

		tmp[start] = '8';
		tmp[end] = '8';
		dfs(tmp, start + 1, end - 1, res);

		if (start < end) {
			tmp[start] = '9';
			tmp[end] = '6';
			dfs(tmp, start + 1, end - 1, res);
		}
	}
}
