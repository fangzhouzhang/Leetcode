import java.util.ArrayList;
import java.util.List;

public class WordSearchIITrie {
	/**
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 * board is m * n, length of one word is l, size of words is k
	 * time: o(m * n * 4^l) space: call stack o(l) stringBuilder o(l) Trie 
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
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				search(board, i, j, root, res, new StringBuilder());
			}
		}

		return res;
	}
	public void search(char[][] board, int i, int j, TrieNode cur,
					   List<String> res, StringBuilder sb) {
		//base case
		if (cur.isWord == true) {
			res.add(new String(sb));
			cur.isWord = false;//dedup
			return;
		}
		//3 terminology conditions
		//out of boundary
		//not match
		//visited
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length||
				board[i][j] == '#' ||
				cur.children[board[i][j] - 'a'] == null) {
			return;
		}
		char ch = board[i][j];
		sb.append(ch);
		board[i][j] = '#';
		int neiX = 0;
		int neiY = 0;
		for (int[] dir : dirs) {
			neiX = dir[0] + i;
			neiY = dir[1] + j;
			search(board, neiX, neiY, cur.children[ch - 'a'], res, sb);
		}
		sb.deleteCharAt(sb.length() - 1);
		board[i][j] = ch;
	}
	public TrieNode buildTrie(List<String> words) {
		TrieNode root = new TrieNode();
		TrieNode cur = root;
		for (String word : words) {
			cur = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (cur.children[ch - 'a'] == null) {
					cur.children[ch - 'a'] = new TrieNode();
				}
				cur = cur.children[ch - 'a'];
			}
			cur.isWord = true;
		}
		return root;
	}
}
