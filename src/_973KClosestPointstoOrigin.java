import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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

	private Random random = new Random();
	public int[][] kClosestQuickPartition(int[][] points, int K) {
		if (points == null || points.length == 0) return new int[0][0];
		int[][] res = new int[K][2];
		int start = 0, end = points.length - 1;
		while (start <= end) {
			int len = sort(points, start, end, K);
			if (len == K) break;
			else if (len < K) start = len;
			else end = len - 2;
		}
		int idx = 0;
		for (int i = 0; i < K; i++) res[idx++] = points[i];
		return res;
	}

	private int sort(int[][] points, int start, int end, int k) {
		if (start >= end) return 1;
		int selectIdx = start + random.nextInt(end - start + 1);
		int pivot = getDistance(points[selectIdx]);
		swap(points, start, selectIdx);
		int pivotIdx = start;
		start++;
		while (start <= end) {
			while (start <= end && getDistance(points[start]) <= pivot) start++;
			while (start <= end && getDistance(points[end]) >= pivot) end--;
			if (start <= end) swap(points, start++, end--);
		}
		swap(points, pivotIdx, end);
		return end + 1;
	}

	private void swap(int[][] arr, int i, int j) {
		int[] tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
