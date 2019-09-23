import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		int i = 0, j = 0;
		List<int[]> res = new ArrayList<>();
		while (i < A.length && j < B.length) {
			int lo = Math.max(A[i][0], B[j][0]);
			int hi = Math.min(A[i][1], B[j][1]);

			if (lo <= hi) res.add(new int[]{lo, hi});

			if (A[i][1] < B[j][1]) i++;
			else j++;
		}
		return res.toArray(new int[res.size()][2]);
	}
}
