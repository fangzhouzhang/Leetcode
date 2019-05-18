import java.util.HashMap;
import java.util.Map;

public class ZumaGame {
	public int findMinStep(String board, String hand) {
		int[] res = new int[1];
		res[0] = Integer.MAX_VALUE;
		Map<Character, Integer> balls = getBall(hand);
		dfs(board, balls, 0, res);
		return res[0] == Integer.MAX_VALUE ? -1 : res[0];
	}
	private Map<Character, Integer> getBall(String hand) {
		Map<Character, Integer> balls = new HashMap<>();
		for (int i = 0; i < hand.length(); i++) {
			char ch = hand.charAt(i);
			if (balls.containsKey(ch)) {
				balls.put(ch, balls.get(ch) + 1);
			} else {
				balls.put(ch, 1);
			}
		}
		return balls;
	}
	private void dfs(String board, Map<Character, Integer> balls, int used, int[] res) {
		if (board.length() == 0) {
			res[0] = Math.min(res[0], used);
			return;
		}
		if (balls.size() == 0) {
			return;
		}

		for (int i = 0; i < board.length(); i++) {
			char ch = board.charAt(i);
			Integer cout = balls.remove(ch);
			if (i == board.length() - 1 || ch != board.charAt(i + 1)) {
				//one consecutive letter
				if (cout != null && cout >= 2) {
					if (cout > 2) {
						balls.put(ch, cout - 2);
					}
					String newBoard = getNewBoard(board, i - 1, i + 1);
					dfs(newBoard, balls, used + 2, res);
				}
			} else if (i < board.length() - 1 && ch == board.charAt(i + 1)) {
				if (cout != null && cout >= 1) {
					if (cout > 1) {
						balls.put(ch, cout - 1);
					}
					String newBoard = getNewBoard(board, i - 1, i + 2);
					dfs(newBoard, balls, used + 1, res);
				}
			}
			if (cout != null) {
				balls.put(ch, cout);
			}
		}
	}
	private String getNewBoard(String board, int i, int j) {
		while (i >= 0 && j < board.length()) {
			int cout = 0;
			int left = i;
			int right = j;
			char ch = board.charAt(i);
			while (left >= 0 && board.charAt(left) == ch) {
				left--;
				cout++;
			}
			while (right < board.length() && board.charAt(right) == ch) {
				right++;
				cout++;
			}
			if (cout >= 3) {
				i = left;
				j = right;
			} else {
				break;
			}
		}
		return board.substring(0, i + 1) + board.substring(j, board.length());
	}
}
