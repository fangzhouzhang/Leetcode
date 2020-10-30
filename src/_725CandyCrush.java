import java.util.ArrayList;
import java.util.List;

public class _725CandyCrush {
	int rows = 0;
	int cols = 0;
	public int[][] candyCrush(int[][] board) {
		if (board == null || board.length == 0) return null;
		rows = board.length;
		cols = board[0].length;
		boolean finish = false;
		while (!finish) {
			List<Integer> dels = new ArrayList<>();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == 0) continue;
					int left = j - 1, right = j + 1;
					int up = i - 1, down = i + 1;
					while (left >= 0 && board[i][left] == board[i][j]) {
						left--;
					}
					while (right < cols && board[i][right] == board[i][j]) {
						right++;
					}
					while (up >= 0 && board[up][j] == board[i][j]) {
						up--;
					}
					while (down < rows && board[down][j] == board[i][j]) {
						down++;
					}
					int hori = right - left - 1;
					int veri = down - up - 1;
					if (hori >=3 || veri >= 3) dels.add(i * cols + j);
				}
			}
			for (int del: dels) {
				board[del / cols][del % cols] = 0;
			}
			finish = dels.size() == 0;
			for (int j = 0; j < cols; j++) {
				int lastPositionToUpdate = rows - 1;
				for (int i = rows - 1; i >= 0; i--) {
					if (board[i][j] == 0) continue;
					int tmp = board[i][j];
					board[i][j] = board[lastPositionToUpdate][j];
					board[lastPositionToUpdate--][j] = tmp;
				}
			}

		}
		return board;
	}
}
