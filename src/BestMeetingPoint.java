import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		getRows(rows, grid);
		getCols(cols, grid);
		return getMin(rows) + getMin(cols);
	}

	private void getRows(List<Integer> rows, int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
				}
			}
		}
	}

	private void getCols(List<Integer> cols, int[][] grid) {
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 1) {
					cols.add(j);
				}
			}
		}
	}

	private int getMin(List<Integer> list) {
		int start = 0;
		int end = list.size() - 1;
		int sum = 0;
		while (start < end) {
			sum += list.get(end--) - list.get(start++);
		}
		return sum;
	}
}
