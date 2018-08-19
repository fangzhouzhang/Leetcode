import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	/**
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 * board is m * n, length of one word is l, size of words is k
	 * time: o(k * m * n * 4^l) space: call stack o(l)
	 */
	public int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
	public List<String> wordSearchII(char[][] board, List<String> words) {
		// write your code here
		List<String> res = new ArrayList<>();
		//sanity check
		if (board == null || words == null ||
				board.length == 0 || words.size() == 0) {
			return res;
		}
		//boolean[][] visited = new boolean[board.length][board[0].length];
		for (String word : words) {
			if (exist(board, word)) {
				res.add(new String(word));
			}
		}
		return res;
	}
	public boolean exist(char[][] board, String word) {
		//traverse all points, if char matches word, check its 4 neighbors
		//or return false and move to next point
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//if searchNeighbors is true, it means starting from
				//board[i][j], there is a neighbor path to match target word
				//if not true, continue next board point
				if (searchNeighbors(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean searchNeighbors(char[][] board, int i, int j, String word,
								   int index) {
		//base case
		if (index == word.length()) {
			return true;
		}

		//3 termination conditions
		//out of boundary
		//not match
		//already visited
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
				word.charAt(index) != board[i][j] || board[i][j] == '#') {
			return false;
		}
		char ch = board[i][j];
		board[i][j] = '#';
		//visited[i][j] = true;
		//dfs
		// 4 branches at most
		// word length levels at most
		int neiX = 0;
		int neiY = 0;
		for (int[] dir: dirs) {
			neiX = dir[0] + i;
			neiY = dir[1] + j;
			if (searchNeighbors(board, neiX, neiY, word, index + 1)) {
				board[i][j] = ch;
				return true;
			}
		}
		board[i][j] = ch;
		return false;
	}
}
