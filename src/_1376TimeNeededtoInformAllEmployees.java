import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1376TimeNeededtoInformAllEmployees {
	private List<Integer>[] g;
	private boolean[] visit;
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		visit = new boolean[n];
		g = new List[n];
		for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i != headID)
				g[manager[i]].add(i);
		}
		int res = Integer.MIN_VALUE;
		Queue<int[]> q = new LinkedList<>();
		int[] start = {headID, 0};
		q.add(start);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			res = Math.max(res, cur[1]);
			for (int w : g[cur[0]]) {
				int[] wa = {w, cur[1] + informTime[cur[0]]};
				q.add(wa);
			}
		}
		return res;
	}
}
