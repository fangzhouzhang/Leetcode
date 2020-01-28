import java.util.*;

public class _1329SorttheMatrixDiagonally {
	public int[][] diagonalSort(int[][] mat) {
		if (mat == null || mat.length == 0) return new int[0][0];
		int row = mat.length, col = mat[0].length;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 1; i < row; i++) {
			int key = i * col + 0;
			map.put(key, new ArrayList<Integer>());
			for (int k = 0; i + k < row && k < col; k++) {
				map.get(key).add(mat[i + k][k]);
			}
		}

		for (int i = 1; i < col; i++) {
			int key = 0 * col + i;
			map.put(key, new ArrayList<Integer>());
			for (int k = 0; k < row && i + k < col; k++) {
				map.get(key).add(mat[k][i + k]);
			}
		}

		map.put(0, new ArrayList<Integer>());
		for (int k = 0; k < row && k < col; k++) {
			map.get(0).add(mat[k][k]);
		}
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			int r = e.getKey() / col;
			int c = e.getKey() % col;
			List<Integer> list = e.getValue();
			Collections.sort(list);
			int idx = 0;
			for (int k = 0; k + r < row && c + k < col; k++) {
				mat[k + r][k + c] = list.get(idx++) ;
			}
		}
		return mat;
	}
}
