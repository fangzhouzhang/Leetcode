import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {
	/**
	 * time: o(m * n) space: o(1)
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		boolean setFirstCol = false;
		boolean setFirstRow = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				setFirstCol = true;
				break;
			}
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				setFirstRow = true;
				break;
			}
		}


		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {

					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (setFirstRow) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		if (setFirstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

	}
}
