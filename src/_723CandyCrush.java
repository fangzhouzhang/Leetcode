import java.util.ArrayList;
import java.util.List;

public class _723CandyCrush {
	public int[][] candyCrush(int[][] board) {
		//search 4 directions and see whether there are >= 3 consecutive same type of candy,
		if (board == null || board.length == 0) return board;
		int rows = board.length, cols = board[0].length;
		while (true) {
			List<Integer> del = new ArrayList<>();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 0) continue;
					//search from left
					if (needCrush(board, i, j)) {
						del.add(i * cols + j);
					}
				}
			}
			if (del.size() == 0) break;
			for (int n : del) {
				board[n / cols][n % cols] = 0;
			}
			for (int j = 0; j < cols; j++) {
				int next_swap_row = rows - 1;
				for (int i = rows - 1; i >= 0; i--) {
					if (board[i][j] != 0) {
						int tmp = board[i][j];
						board[i][j] = board[next_swap_row][j];
						board[next_swap_row][j] = tmp;
						next_swap_row--;
					}
				}
			}
		}
		return board;
	}

	private boolean needCrush(int[][] a, int r, int c) {
		int y0 = c - 1;
		while (y0 >= 0 && a[r][y0] == a[r][c]) y0--;
		int y1 = c + 1;
		while (y1 < a[r].length && a[r][y1] == a[r][c]) y1++;
		int x0 = r - 1;
		while (x0 >= 0 && a[x0][c] == a[r][c]) x0--;
		int x1 = r + 1;
		while (x1 < a.length && a[x1][c] == a[r][c]) x1++;
		if (x1 - x0 - 1 >= 3 || y1 - y0 - 1 >= 3) return true;
		else return false;
	}
}
