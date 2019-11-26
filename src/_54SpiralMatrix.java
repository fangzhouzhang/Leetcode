import java.util.ArrayList;
import java.util.List;

public class _54SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
		int dir = 0;
		int top = 0, bottom = matrix.length - 1;
		int left = 0, right = matrix[0].length - 1;
		while (top <= bottom && left <= right) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) res.add(matrix[top][i]);
				top++;
			} else if (dir == 1) {
				for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
				right--;
			} else if (dir == 2) {
				for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
				bottom--;
			} else {
				for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
				left++;
			}
			dir = (dir + 1) % 4;
		}
		return res;
	}
}
