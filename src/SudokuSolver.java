public class SudokuSolver {
	private boolean[][] row_u = new boolean[9][10];
	private boolean[][] col_u = new boolean[9][10];
	private boolean[][] box_u = new boolean[9][10];
	public void solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					row_u[i][num] = true;
					col_u[j][num] = true;
					box_u[i / 3 * 3 + j / 3][num] = true;
				}
			}
		}
		fillIn(board, 0, 0);
	}
	private boolean fillIn(char[][] board, int row, int col) {
		if (col == 9) {
			return true;
		}

		int nx = (row + 1) % 9;
		int ny = (nx == 0) ? col + 1 : col;

		for (int i = 1; i <= 9; i++) {
			if (board[row][col] != '.') {
				return fillIn(board, nx, ny);
			}
			if (!row_u[row][i] && !col_u[col][i] && !box_u[row / 3 * 3 + col / 3][i]) {
				board[row][col] = (char)(i + '0');
				row_u[row][i] = true;
				col_u[col][i] = true;
				box_u[row / 3 * 3 + col / 3][i] = true;
				if (fillIn(board, nx, ny)) {
					return true;
				}
				board[row][col] = '.';
				row_u[row][i] = false;
				col_u[col][i] = false;
				box_u[row / 3 * 3 + col / 3][i] = false;
			}
		}
		return false;
	}
}
