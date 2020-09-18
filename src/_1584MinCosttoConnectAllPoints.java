import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _1584MinCosttoConnectAllPoints {
	public int minCostConnectPoints(int[][] points) {
		if (points == null || points.length <= 1) return 0;
		//search all distance
		Set<int[]> set = new HashSet<>();
		int n = points.length;
		set.add(points[0]);
		int res = 0;

		Queue<int[]> q = new LinkedList<>();
		q.add(points[0]);
		while (set.size() < n) {
			int size = q.size();
			PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int[] next : points) {
					if (set.contains(next)) continue;
					pq.add(new Pair(Math.abs(cur[0] - next[0]) + Math.abs(cur[1] - next[1]), next));
				}
			}
			Pair p = pq.poll();
			res += p.val;
			set.add(p.a);
			for (int[] arr : set) q.add(arr);
		}
		return res;
	}

	public class Pair {
		int val;
		int[] a;
		public Pair(int val, int[] a) {
			this.val = val;
			this.a = a;
		}
	}

	public class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.val - b.val;
		}
	}
}
