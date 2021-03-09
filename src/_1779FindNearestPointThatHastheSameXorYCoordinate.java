public class _1779FindNearestPointThatHastheSameXorYCoordinate {
	public int nearestValidPoint(int x, int y, int[][] points) {
		int min = Integer.MAX_VALUE, res = 0, n = points.length;
		for (int[] p : points) {
			if (p[0] == x || p[1] == y) {
				if (min >= Math.abs(x - p[0]) + Math.abs(y - p[1])) {
					min = Math.abs(x - p[0]) + Math.abs(y - p[1]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int[] p = points[i];
			if (p[0] == x || p[1] == y) {
				if (min == Math.abs(x - p[0]) + Math.abs(y - p[1])) {
					return i;
				}
			}
		}
		return -1;
	}
}
