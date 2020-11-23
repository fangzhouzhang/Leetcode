import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _743NetworkDelayTime {
	private int[] dis;
	private boolean[] visit;
	private List<int[]>[] g;
	public int networkDelayTime(int[][] times, int N, int K) {
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[K] = 0;
		visit = new boolean[N + 1];
		g = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			g[i] = new ArrayList<>();
		}
		for (int[] t : times) {
			int[] nei = {t[1], t[2]};
			g[t[0]].add(nei);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
		int[] start = {K, 0};
		int res = Integer.MIN_VALUE;
		pq.add(start);
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for (int[] nei : g[cur[0]]) {
				if (visit[nei[0]]) continue;
				if (dis[nei[0]] > cur[1] + nei[1]) {
					dis[nei[0]] = cur[1] + nei[1];
					int[] arr = {nei[0], cur[1] + nei[1]};
					pq.add(arr);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) return -1;
		}
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, dis[i]);
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[1] - b[1];
		}
	}
}
