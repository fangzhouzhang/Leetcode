public class _79WordSearch {
	private int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) return false;
		if (word == null || word.length() == 0) return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, i, j, word, 0)) return true;
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int row, int col, String word, int idx) {
		if (idx == word.length()) return true;
		if (!isValid(board, row, col) || board[row][col] != word.charAt(idx)) return false;
		char tmp = board[row][col];
		board[row][col] = '#';
		for (int[] dir : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (dfs(board, newRow, newCol, word, idx + 1)) return true;
		}
		board[row][col] = tmp;
		return false;
	}

	private boolean isValid(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length) {
			return false;
		}
		if (col < 0 || col >= board[row].length) {
			return false;
		}
		if (board[row][col] == '#') {
			return false;
		}
		return true;
	}
}
