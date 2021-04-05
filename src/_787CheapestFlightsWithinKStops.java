import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _787CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[src] = 0;
		boolean[] visit = new boolean[n];
		int res = Integer.MAX_VALUE;
		List<int[]>[] g = new List[n];
		for (int i = 0; i < n; i++) g[i] = new ArrayList<int[]>();
		for (int[] f : flights) {
			g[f[0]].add(f);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
		int[] arr = {/*cur_node=*/src, /*dis_to_src=*/0, /*node_number=*/1};
		pq.add(arr);

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[0] != dst && cur[2] > K + 1) continue;
			if (cur[0] == dst && cur[2] > K + 2) continue;
			if (cur[0] == dst) return cur[1];
			// if (visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for (int[] a : g[cur[0]]) {
				int[] b = {a[1], cur[1] + a[2], cur[2] + 1};
				pq.add(b);
			}
		}
		return -1;
	}

	class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[1] - b[1];
		}
	}
}
