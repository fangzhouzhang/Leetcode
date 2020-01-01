import java.util.Comparator;
import java.util.PriorityQueue;

public class _973KClosestPointstoOrigin {
	public int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0) return new int[0][0];
		int[][] res = new int[K][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>(K, new MyComparator());
		for (int[] point : points) {
			if (pq.size() == K) {
				if (getDistance(point) < getDistance(pq.peek())) {
					pq.poll();
					pq.add(point);
				}
			} else {
				pq.add(point);
			}
		}
		int idx = 0;
		while (!pq.isEmpty()) {
			res[idx++] = pq.poll();
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return getDistance(b) - getDistance(a);
		}
	}

	private int getDistance(int[] a) {
		return a[0] * a[0] + a[1] * a[1];
	}
}
