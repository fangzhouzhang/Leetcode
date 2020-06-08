import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1471ThekStrongestValuesinanArray {
	public int[] getStrongest(int[] arr, int k) {
		if (arr == null || arr.length == 0) return new int[0];
		Arrays.sort(arr);
		int m = arr[(arr.length - 1) / 2];
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator(m));
		for (int n : arr) {
			if (pq.size() < k) pq.add(n);
			else {
				if (Math.abs(n - m) > Math.abs(pq.peek() - m) || (Math.abs(n - m) == Math.abs(pq.peek() - m) && n > pq.peek())) {
					pq.poll();
					pq.add(n);
				}
			}
		}
		int[] res = new int[k];
		int idx = 0;
		while (!pq.isEmpty()) res[idx++] = pq.poll();
		return res;
	}

	private class MyComparator implements Comparator<Integer> {
		private int m;
		public MyComparator(int m) {
			this.m = m;
		}

		public int compare(Integer a, Integer b) {
			if (Math.abs(a - m) != Math.abs(b - m)) return Math.abs(a - m) - Math.abs(b - m);
			else {
				return a - b;
			}
		}
	}
}
