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

	/**
	 * 28/30 test cases
	 * @param transactions
	 * @return
	 */
	public int minTransfersWrong(int[][] transactions) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] t : transactions) {
			if (!map.containsKey(t[0])) map.put(t[0], 0);
			if (!map.containsKey(t[1])) map.put(t[1], 0);
			map.put(t[0], map.get(t[0]) - t[2]);
			map.put(t[1], map.get(t[1]) + t[2]);
		}
		Map<Integer, Integer> vals = new HashMap<>();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == 0) continue;
			if (!vals.containsKey(e.getValue())) {
				vals.put(e.getValue(), 1);
			} else {
				vals.put(e.getValue(), vals.get(e.getValue()) + 1);
			}

		}

		int res = 0;
		for (Map.Entry<Integer, Integer> e : vals.entrySet()) {
			int curVal = e.getKey();
			int oppoVal = -1 * curVal;
			if (vals.containsKey(oppoVal) && (vals.get(oppoVal) > 0)) {
				int curFreq = vals.get(curVal);
				int oppoFreq = vals.get(oppoVal);
				if (curFreq > oppoFreq) {
					res += oppoFreq;
					vals.put(curVal, curFreq - oppoFreq);
					vals.put(oppoVal, 0);
				} else if (curFreq < oppoFreq) {
					res += curFreq;
					vals.put(curVal, 0);
					vals.put(oppoVal, oppoFreq - curFreq);
				} else {
					res += oppoFreq;
					vals.put(curVal, 0);
					vals.put(oppoVal, 0);
				}
			}
		}
		PriorityQueue<Pair> ns = new PriorityQueue<>(new MyComparator());
		PriorityQueue<Pair> ps = new PriorityQueue<>(new MyComparator());
		for (Map.Entry<Integer, Integer> e : vals.entrySet()) {
			int num = e.getValue();
			if (num == 0) continue;
			for (int i = 0; i < num; i++) {
				if (e.getKey() > 0) {
					ps.add(new Pair(e.getKey(), e.getValue()));
				}
				if (e.getKey() < 0) {
					ns.add(new Pair(Math.abs(e.getKey()), e.getValue()));
				}
			}
		}

		while (!ps.isEmpty() && !ns.isEmpty()) {
			Pair p = ps.poll();
			Pair n = ns.poll();
			if (p.val > n.val) {
				res++;
				//put p back
				p.val -= n.val;
				ps.add(p);
			} else if (p.val < n.val) {
				//put p back
				res++;
				n.val -= p.val;
				ns.add(n);
			} else {
				//just res++
				res++;
			}
		}
		return res;

	}

	class Pair {
		int val;
		int idx;
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

	class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.val != b.val) {
				return b.val - a.val;
			}
			return 0;
		}
	}
}
