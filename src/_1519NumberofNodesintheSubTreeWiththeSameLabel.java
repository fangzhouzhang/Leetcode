import java.util.ArrayList;
import java.util.List;

public class _1519NumberofNodesintheSubTreeWiththeSameLabel {
	public int[] countSubTrees(int n, int[][] edges, String labels) {
		Node[] nodes = new Node[n];
		for (int i = 0; i < labels.length(); i++) {
			nodes[i] = new Node(labels.charAt(i), i);
		}
		for (int[] e: edges) {
			nodes[e[0]].children.add(e[1]);
			nodes[e[1]].children.add(e[0]);
		}
		boolean[] visit = new boolean[n];
		dfs(nodes, 0, visit);
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = nodes[i].count[nodes[i].c - 'a'];
		}
		return res;
	}

	private void dfs(Node[] nodes, int idx, boolean[] visit) {
		visit[idx] = true;
		for (int next : nodes[idx].children) {
			if (visit[next]) continue;
			dfs(nodes, next, visit);
			for (int i = 0; i < 26; i++) {
				nodes[idx].count[i] += nodes[next].count[i];
			}
		}
	}

	private class Node {
		int[] count;
		int key;
		char c;
		List<Integer> children;
		public Node(char c, int key) {
			this.c = c;
			this.key = key;
			count = new int[26];
			count[c - 'a'] = 1;
			children = new ArrayList<>();
		}
	}
}
