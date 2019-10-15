public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		int num = 1;
		int dir = 0;
		int[][] m = new int[n][n];
		while (top <= bottom && left <= right) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) m[top][i] = num++;
				top++;
				dir = 1;
			} else if (dir == 1) {
				for (int i = top; i <= bottom; i++) m[i][right] = num++;
				right--;
				dir = 2;
			} else if (dir == 2) {
				for (int i = right; i >= left; i--) m[bottom][i] = num++;
				bottom--;
				dir = 3;
			} else {
				for (int i = bottom; i >= top; i--) m[i][left] = num++;
				left++;
				dir = 0;
			}
		}
		return m;
	}
}
