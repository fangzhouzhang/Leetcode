public class ValidTicTacToeState {
	public boolean validTicTacToe(String[] board) {
		int x = 0, o = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'X') x++;
				if (board[i].charAt(j) == 'O') o++;
			}
		}
		if (!(x == o || x == o + 1)) return false;
		boolean xwin = win(board, 'X');
		boolean owin = win(board, 'O');
		if (x == o && xwin) return false;
		if (x == o + 1 && owin) return false;
		return true;
	}

	private boolean win(String[] board, char c) {
		for (int i = 0; i < board.length; i++) {
			if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2) && board[i].charAt(0) == c) return true;
		}

		for (int j = 0; j < board[0].length(); j++) {
			if (board[0].charAt(j) == board[1].charAt(j) && board[0].charAt(j) == board[2].charAt(j) && board[0].charAt(j) == c) return true;
		}

		if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2) && board[0].charAt(0) == c) return true;
		if (board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0) && board[0].charAt(2) == c) return true;
		return false;
	}
}
