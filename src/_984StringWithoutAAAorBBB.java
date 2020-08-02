import java.util.Comparator;
import java.util.PriorityQueue;

public class _984StringWithoutAAAorBBB {
	public String strWithout3a3b(int A, int B) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
		pq.add(new Pair('a', A));
		pq.add(new Pair('b', B));
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			if (pq.size() == 1) {
				Pair p = pq.poll();
				for (int i = 0; i < p.fre; i++) {
					sb.append(p.c);
				}
			} else {
				Pair a = pq.poll();
				Pair b = pq.poll();
				int k = 0;
				if (a.fre != b.fre) {
					k = Math.min(2, a.fre - b.fre);
				} else {
					k = 1;
				}
				for (int i = 0; i < k; i++) {
					sb.append(a.c);
				}
				sb.append(b.c);
				if (a.fre - k  > 0) {
					a.fre -= k;
					pq.add(a);
				}
				if (b.fre - 1 > 0) {
					b.fre -= 1;
					pq.add(b);
				}
			}
		}
		return new String(sb);
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return b.fre - a.fre;
		}
	}

	private class Pair {
		char c;
		int fre;
		public Pair(char c, int fre) {
			this.c = c;
			this.fre = fre;
		}
	}
}
