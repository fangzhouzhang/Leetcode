import java.util.Comparator;
import java.util.PriorityQueue;

public class _1753MaximumScoreFromRemovingStones {
	public int maximumScore(int a, int b, int c) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
		pq.add(a);
		pq.add(b);
		pq.add(c);
		int res = 0;
		while (pq.size() >= 2) {
			int aa = pq.poll();
			int bb = pq.poll();
			aa--;
			bb--;
			if (aa > 0) pq.add(aa);
			if (bb > 0) pq.add(bb);
			res++;
		}
		return res;
	}

	private class MyComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}
}
