import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length <= 1) {
			return points.length;
		}
		Arrays.sort(points, new MyComparator());
		int min = points[0][1];
		int res = 1;
		/**
		 如果需要增加一剑，尽可能延展结尾，这样可以减少后面需要增加的数量。
		 选择当前结尾与最小结尾的最小值
		 **/
		for (int i = 1; i < points.length; i++) {
			if (min >= points[i][0]) {
				min = Math.min(min, points[i][1]);
			} else {
				res++;
				min = points[i][1];
			}
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] != b[0] ? a[0] - b[0] : a[1] - b [1];
		}
	}
}
