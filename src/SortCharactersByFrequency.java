import java.util.Comparator;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		if (s.length() == 0)
			return "";
		int[] map = new int[128];
		for (char c : s.toCharArray()) {
			int idx = (int)c;
			map[idx]++;
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
		for (int i = 0; i < map.length; i++) {
			char c = (char)i;
			if (map[i] > 0) {
				pq.add(new Pair(c, map[i]));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			for (int i = 0; i < p.fre; i++) {
				sb.append(p.val);
			}
		}
		return new String(sb);
	}

	private class Pair {
		public char val;
		public int fre;
		public Pair(char v, int f) {
			val = v;
			fre = f;
		}
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return b.fre - a.fre;
		}
	}
}
