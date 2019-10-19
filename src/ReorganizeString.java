import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
	public String reorganizeString(String S) {
		if (S == null || S.length() == 0) return "";
		int[] map = new int[26];
		for (char c : S.toCharArray()) map[c - 'a']++;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
		for (int i = 0; i < 26; i++) {
			if (map[i] > 0) {
				char c = (char)(i + 'a');
				pq.add(new Pair(c, map[i]));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != p.c) {
				sb.append(p.c);
				p.fre--;
				if (p.fre > 0) pq.add(p);
			} else if (sb.charAt(sb.length() - 1) == p.c) {
				if (pq.size() == 0) return "";
				Pair q = pq.poll();
				sb.append(q.c);
				q.fre--;
				if (q.fre > 0) pq.add(q);
				pq.add(p);
			}

		}
		return new String(sb);
	}

	private class Pair{
		char c;
		int fre;
		public Pair(char c, int fre) {
			this.c = c;
			this.fre = fre;
		}
	}


	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.fre != b.fre) return b.fre - a.fre;
			else return a.c - b.c;
		}
	}
}
