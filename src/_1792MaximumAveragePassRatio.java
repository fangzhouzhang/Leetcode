import java.util.Comparator;
import java.util.PriorityQueue;

public class _1792MaximumAveragePassRatio {
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new MC());
		for (int[] a : classes)
			if (a[0] < a[1])
				pq.add(a);
		double res = 0;
		while (extraStudents > 0 && !pq.isEmpty()) {
			int[] cur = pq.poll();
			cur[0] += 1;
			cur[1] += 1;
			pq.add(cur);
			extraStudents--;
		}
		int n = classes.length, m = pq.size();
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			res += cur[0] * 1.0 / cur[1];
		}
		return (res + n - m) / n;
	}

	private class MC implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			double d0=(double)(a[0]+1)/(a[1]+1) - (double)(a[0])/a[1];
			double d1=(double)(b[0]+1)/(b[1]+1) - (double)(b[0])/b[1];
			if(d1>d0) return 1;
			else return -1;
		}
	}
}
