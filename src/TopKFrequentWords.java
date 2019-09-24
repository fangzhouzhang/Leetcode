import java.util.*;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		LinkedList<String> res = new LinkedList<>();
		if (words.length == 0) return res;
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new MyComparator());
		Map<String, Integer> m = new HashMap<>();
		for (String s: words) {
			m.put(s, m.getOrDefault(s, 0) + 1);
		}
		for (Map.Entry<String, Integer> e : m.entrySet()) {
			Pair p = new Pair(e.getKey(), e.getValue());
			if (pq.size() < k) {
				pq.add(p);
			} else if (pq.size() == k) {
				if (p.value > pq.peek().value || (p.value == pq.peek().value && p.key.compareTo(pq.peek().key) < 0)) {
					pq.poll();
					pq.add(p);
				}
			}
		}
		while (!pq.isEmpty()) {
			res.add(0, pq.poll().key);
		}
		return res;
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.value != b.value) return a.value - b.value;
			return b.key.compareTo(a.key);
		}
	}

	private class Pair {
		private String key;
		private int value;
		public Pair(String k, int v) {
			key = k;
			value = v;
		}
	}
}
