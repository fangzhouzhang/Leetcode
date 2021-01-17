public class _1725NumberOfRectanglesThatCanFormTheLargestSquare {
	public int countGoodRectangles(int[][] rectangles) {
		if (rectangles == null || rectangles.length == 0) return 0;
		int n = rectangles.length;
		int[] sides = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			sides[i] = Math.min(rectangles[i][0], rectangles[i][1]);
			max = Math.max(max, sides[i]);
		}
		int res = 0;
		for (int x : sides) {
			if (x == max) res++;
		}
		return res;
	}
}
