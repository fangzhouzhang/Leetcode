import java.util.ArrayList;
import java.util.List;

public class _212WordSearchII {
	/**
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 * board is m * n, length of one word is l, size of words is k
	 * time: o(k * m * n * 4^l) space: call stack o(l)
	 */
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) return res;
		TrieNode root = new TrieNode();
		for (String word : words) buildTrie(root, word);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				dfs(board, i, j, res, root);
			}
		}
		return res;
	}

	private void dfs(char[][] board, int row, int col, List<String> res, TrieNode root) {
		char c = board[row][col];
		if (root.children[c - 'a'] == null) return;
		if (root.children[c - 'a'].word != null) {
			res.add(root.children[c - 'a'].word);
			root.children[c - 'a'].word = null;
		}
		board[row][col] = '#';
		for (int[] dir : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (isValid(board, newRow, newCol)) dfs(board, newRow, newCol, res, root.children[c - 'a']);
		}
		board[row][col] = c;
	}

	private boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length) return false;
		if (j < 0 || j >= board[i].length) return false;
		if (board[i][j] == '#') return false;
		return true;
	}

	private class TrieNode {
		TrieNode[] children;
		String word;
		public TrieNode() {
			children = new TrieNode[26];
			word = null;
		}
	}

	private void buildTrie(TrieNode root, String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
			cur = cur.children[c - 'a'];
		}
		cur.word = word;
	}
}
