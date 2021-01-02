import java.util.PriorityQueue;

public class _1705MaximumNumberofEatenApples {
	public int eatenApples(int[] apples, int[] days) {
		int res = 0, n = apples.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		for (int i = 0; i < n || !pq.isEmpty(); i++) {
			if (i < n) {
				pq.add(new int[]{apples[i], i + days[i] - 1});
			}
			while (!pq.isEmpty() && pq.peek()[1] < i) pq.poll();
			if (!pq.isEmpty()) {
				res++;
				int[] cur = pq.poll();
				cur[0]--;
				if (cur[0] != 0) pq.add(cur);
			}
		}
		return res;
	}
}
