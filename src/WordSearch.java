public class WordSearch {
	public int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (search(board, i, j, word, 0, word.length())) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean search(char[][] board, int i, int j, String word, int idx, int len) {
		if (idx == word.length()) {
			return true;
		}

		if (word.charAt(idx) != board[i][j]) {
			return false;
		}
		//current char is right, len --

		//set visited
		char temp = board[i][j];
		board[i][j] = '#';

		for (int[] dir : dirs) {
			int newRow = dir[0] + i;
			int newCol = dir[1] + j;
			if (isValid(board, newRow, newCol) && search(board, newRow, newCol, word, idx + 1, len - 1)) {
				return true;
			}
		}

		//unset visited
		board[i][j] = temp;
		if (len - 1 > 0) {
			return false;
		} else {
			return true;
		}

	}
	private boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length) {
			return false;
		}
		if (j < 0 || j >= board[0].length) {
			return false;
		}
		if (board[i][j] == '#') {
			return false;
		}
		return true;
	}
}
