import java.util.*;

public class _692TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0) return res;
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new MyComparator());
		Map<String, Integer> map = new HashMap<>();
		for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
		for (Map.Entry<String, Integer> e: map.entrySet()) {
			if (pq.size() >= k) {
				if (e.getValue() > pq.peek().fre ||
						(e.getValue() == pq.peek().fre && e.getKey().compareTo(pq.peek().word) < 0)) {
					pq.poll();
					pq.add(new Pair(e.getKey(), e.getValue()));
				}
			} else pq.add(new Pair(e.getKey(), e.getValue()));
		}
		for (int i = 0; i < k; i++) res.add("");
		int idx = k - 1;
		while (!pq.isEmpty()) res.set(idx--, pq.poll().word);
		return res;
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.fre != b.fre) return a.fre - b.fre;
			else return b.word.compareTo(a.word);
		}
	}

	private class Pair {
		String word;
		int fre;
		public Pair(String w, int f) {
			this.word = w;
			this.fre = f;
		}
	}
}
