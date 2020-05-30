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
	TrieNode root = new TrieNode();
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (null == board || board.length == 0 || words == null || words.length == 0) return res;
		for (String word : words) buildTrie(word);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int idx = board[i][j] - 'a';
				if (root.children[idx] != null) {
					dfs(root, board, i, j, new StringBuilder(), res);
				}
			}
		}
		return res;
	}

	private boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length) {
			return false;
		}
		if (j < 0 || j >= board[i].length) {
			return false;
		}
		if (board[i][j] == '#') {
			return false;
		}
		return true;
	}

	private void dfs(TrieNode cur, char[][] b, int row, int col, StringBuilder sb, List<String> res) {
		char tmp = b[row][col];
		if (cur == null || cur.children[tmp - 'a'] == null) return;
		b[row][col] = '#';
		sb.append(tmp);
		if (cur.children[tmp - 'a'].isEnd) {
			res.add(new String(sb));
			cur.children[tmp - 'a'].isEnd = false;
		}
		for (int[] dir : dirs) {
			int next_r = row + dir[0];
			int next_c = col + dir[1];
			if (!isValid(b, next_r, next_c)) continue;
			dfs(cur.children[tmp - 'a'], b, next_r, next_c, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		b[row][col] = tmp;
	}

	private void buildTrie(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
			cur = cur.children[idx];
		}
		cur.isEnd = true;
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEnd = false;
		public TrieNode() {
		}
	}
}
