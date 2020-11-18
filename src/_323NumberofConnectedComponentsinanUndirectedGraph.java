import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _323NumberofConnectedComponentsinanUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		if (edges == null || edges.length == 0) return n;
		UnionFind uf = new UnionFind(n);
		for (int[] e : edges) {
			int u = e[0];
			int v = e[1];
			uf.union(u, v);
		}
		return uf.number;
	}

	private class UnionFind {
		int[] parent;
		int[] rank;
		int number;
		public UnionFind(int n) {
			number = n;
			parent = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}

		public int getParent(int x) {
			if (parent[x] == x) return x;
			return parent[x] = getParent(parent[x]);
		}

		public void union(int a, int b) {
			int rootA = getParent(a);
			int rootB = getParent(b);
			if (rootA == rootB) return;
			if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
			number--;
		}
	}

	public int countComponentsDfs(int n, int[][] edges) {
		int[] visit = new int[n];
		Arrays.fill(visit, -1);
		List<Integer>[] adj = new List[n];
		for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
		for (int[] e : edges) {
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
		}
		int ccNum = 0;
		for (int v = 0; v < n; v++) {
			if (visit[v] != -1) continue;
			dfs(v, adj, ccNum, visit);
			ccNum++;
		}
		return ccNum;
	}

	private void dfs(int v, List<Integer>[] adj, int ccNum, int[] visit) {
		visit[v] = ccNum;
		for (int w: adj[v]) {
			if (visit[w] != -1) continue;
			dfs(w, adj, ccNum, visit);
		}
	}
}
