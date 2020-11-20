import java.util.Comparator;
import java.util.PriorityQueue;

public class _767ReorganizeString {
	public String reorganizeString(String S) {
		if (S == null || S.length() == 0) return "";
		char[] a = S.toCharArray();
		int[] map = new int[26];
		for (char c : a) {
			int idx = (int)(c - 'a');
			map[idx] += 1;
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
		for (int i = 0; i < 26; i++) {
			if (map[i] == 0) continue;
			char c = (char)(i + 'a');
			pq.add(new Pair(map[i], c));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != p.c) {
				sb.append(p.c);
				p.fre--;
				if (p.fre > 0) {
					pq.add(p);
				}
			} else {
				if (pq.isEmpty()) continue;
				Pair another = pq.poll();
				sb.append(another.c);
				another.fre--;
				if (another.fre > 0) pq.add(another);
				pq.add(p);
			}
		}
		return sb.length() == S.length() ? new String(sb) : "";
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return b.fre - a.fre;
		}
	}

	private class Pair {
		int fre;
		char c;
		public Pair(int fre, char c) {
			this.fre = fre;
			this.c = c;
		}
	}
}
