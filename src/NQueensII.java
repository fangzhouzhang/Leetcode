public class NQueensII {
	public int totalNQueens(int n) {
		int[] res = new int[1];
		int[] pos = new int[n];
		dfs(res, pos, 0);
		return res[0];
	}
	private void dfs(int[] res, int[] pos, int idx) {
		if (idx == pos.length) {
			res[0]++;
			return;
		}

		for (int i = 0; i < pos.length; i++) {
			if (!attack(pos, idx, i)) {
				pos[idx] = i;
				dfs(res, pos, idx + 1);
			}
		}
	}
	private boolean attack(int[] pos, int idx, int cur) {
		for (int i = 0; i < idx; i++) {
			if (pos[i] == cur || Math.abs(pos[i] - cur) == Math.abs(i - idx)) {
				return true;
			}
		}
		return false;
	}
}
