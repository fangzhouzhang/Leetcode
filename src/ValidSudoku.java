public class ValidSudoku {
	boolean[][] row = new boolean[9][10];
	boolean[][] col = new boolean[9][10];
	boolean[][] box = new boolean[9][10];
	public boolean isValidSudoku(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					if (isValid(num, i, j)) {
						row[i][num] = true;
						col[j][num] = true;
						box[i / 3 * 3 + j / 3][num] = true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	private boolean isValid(int num, int i, int j) {
		if (row[i][num]) {
			return false;
		}
		if (col[j][num]) {
			return false;
		}
		if (box[i / 3 * 3 + j / 3][num]) {
			return false;
		}
		return true;
	}
}
