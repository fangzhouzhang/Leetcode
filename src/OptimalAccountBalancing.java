import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
	public int minTransfers(int[][] transactions) {
		if (transactions.length == 0 || transactions[0].length == 0) {
			return 0;
		}
		Map<Integer,Integer> map = new HashMap<>();
		for (int[] t : transactions) {
			map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
			map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
		}
		int[] acc = new int[map.size()];
		int idx = 0;
		for (Map.Entry<Integer,Integer> e: map.entrySet()) {
			if (e.getValue() != 0) {
				acc[idx++] = e.getValue();
			}
		}
		if (idx == 0) {
			return 0;
		}
		return dfs(acc, 0, idx);
	}

	private int dfs(int[] acc, int start, int len) {
		while (start < len && acc[start] == 0) {
			start++;
		}
		if (start == len) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		for (int i = start + 1; i < len; i++) {
			if (acc[i] * acc[start] < 0) {
				acc[i] += acc[start];
				res = Math.min(res, 1 + dfs(acc, start + 1, len));
				acc[i] -= acc[start];
			}
		}
		return res;
	}
}
