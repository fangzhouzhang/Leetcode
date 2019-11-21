import java.util.*;

public class _347TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new MyComparator());
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (pq.size() >= k) {
				if (pq.peek().fre < e.getValue()) {
					pq.poll();
					pq.add(new Pair(e.getKey(), e.getValue()));
				}
			} else {
				pq.add(new Pair(e.getKey(), e.getValue()));
			}
		}
		while (!pq.isEmpty()) res.add(pq.poll().val);
		return res;
	}


	private class Pair {
		int val;
		int fre;
		public Pair(int val, int fre) {
			this.val = val;
			this.fre = fre;
		}
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.fre != b.fre) return a.fre - b.fre;
			return 0;
		}
	}
}
