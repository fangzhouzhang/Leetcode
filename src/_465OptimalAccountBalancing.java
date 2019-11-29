import java.util.*;

public class _465OptimalAccountBalancing {
	public int minTransfers(int[][] transactions) {
		if (transactions == null || transactions.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] t : transactions) {
			map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
			map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
		}
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() != 0) list.add(e.getValue());
		}
		Collections.sort(list);
		int i = 0, j = list.size() - 1, pairs = 0;
		while (i < j) {
			if (list.get(i) + list.get(j) == 0) {
				list.set(i, 0);
				list.set(j, 0);
				pairs++;
				i++;
				j--;
			} else if (list.get(i) + list.get(j) < 0) {
				i++;
			} else j--;
		}
		return pairs + dfs(list, 0);
	}

	private int dfs(List<Integer> list, int idx) {
		if (idx == list.size()) return 0;
		if (list.get(idx) == 0) return dfs(list, idx + 1);
		int cur = list.get(idx);
		int min = Integer.MAX_VALUE;
		for (int i = idx + 1; i < list.size(); i++) {
			int next = list.get(i);
			if (cur * next < 0) {
				list.set(i, cur + next);
				min = Math.min(min, 1 + dfs(list, idx + 1));
				list.set(i, next);
			}
		}
		return min;
	}
}
