import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	/**
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 * board is m * n, length of one word is l, size of words is k
	 * time: o(k * m * n * 4^l) space: call stack o(l)
	 */
	private int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
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
	private boolean exist(char[][] board, String word) {
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
	private boolean searchNeighbors(char[][] board, int i, int j, String word,
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
	/**
	 * trie version
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 * board is m * n, length of one word is l, size of words is k
	 * time: o(m * n * 4^l) space: call stack o(l)
	 */
	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		for (String word: words) {
			buildTrie(root, word);
		}
		List<String> res = new ArrayList<>();
		Set<String> dedup = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				search(board, i, j, res, sb, root, dedup);
			}
		}
		return res;
	}
	private void buildTrie(Trie root, String word) {
		Trie cur = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (cur.children[ch - 'a'] != null) {
				if (i == word.length() - 1) {
					cur.children[ch - 'a'].isEnd = true;
				}
			} else {
				Trie node = new Trie();
				cur.children[ch - 'a'] = node;
				if (i == word.length() - 1) {
					cur.children[ch - 'a'].isEnd = true;
				}
			}
			cur = cur.children[ch - 'a'];
		}
	}
	private void search(char[][] board, int row, int col, List<String> res, StringBuilder sb, Trie root, Set<String> dedup) {
		char ch = board[row][col];
		if (root.children[ch - 'a'] == null) {
			return;
		}
		board[row][col] = '#';
		int prev = sb.length();
		sb.append(ch);

		if (root.children[ch - 'a'].isEnd == true && dedup.add(new String(sb))) {
			res.add(new String(sb));
		}

		for (int[] dir : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (isValid(board, newRow, newCol)) {
				search(board, newRow, newCol, res, sb, root.children[ch - 'a'], dedup);
			}
		}

		//set back
		sb.setLength(prev);
		board[row][col] = ch;
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
	private class Trie {
		private Trie[] children;
		private boolean isEnd;
		public Trie() {
			this.children = new Trie[26];
			this.isEnd = false;
		}
	}
}
