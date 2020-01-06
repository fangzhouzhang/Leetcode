import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _305NumberofIslandsII {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();
		if (positions == null || positions.length == 0) return res;
		UnionFind uf = new UnionFind(m * n);
		for (int[] p : positions) {
			dfs(p, uf, m, n);
			res.add(uf.size);
		}
		return res;
	}

	private void dfs(int[] p, UnionFind uf, int m, int n) {
		uf.createIsland(p[0] * n + p[1]);
		for (int[] dir : dirs) {
			int newRow = p[0] + dir[0];
			int newCol = p[1] + dir[1];
			if (isValid(newRow, newCol, m, n, uf)) uf.union(p[0] * n + p[1], newRow * n + newCol);
		}
	}

	private boolean isValid(int i, int j, int m, int n, UnionFind uf) {
		if (i < 0 || i >= m) return false;
		if (j < 0 || j >= n) return false;
		if (uf.parent[i * n + j] == -1) return false;
		return true;
	}

	private class UnionFind{
		int[] parent;
		int[] rank;
		int size;
		public UnionFind(int length) {
			parent = new int[length];
			rank = new int[length];
			Arrays.fill(parent, -1);
			size = 0;
		}

		private void createIsland(int idx) {
			if (parent[idx] == -1) {
				size++;
				parent[idx] = idx;
				rank[idx] = 1;
			}
		}

		private int findRoot(int idx) {
			if (parent[idx] == idx) return idx;
			int father = findRoot(parent[idx]);
			parent[idx] = father;
			return father;
		}

		private void union(int a, int b) {
			int rootA = findRoot(a);
			int rootB = findRoot(b);
			if (rootA == -1 || rootB == -1) return;
			if (rootA != rootB) {
				if (rank[rootA] > rank[rootB]) parent[rootB] = rootA;
				else if (rank[rootA] < rank[rootB]) parent[rootA] = rootB;
				else {
					parent[rootA] = rootB;
					rank[rootB]++;
				}
				size--;
			}
		}
	}
}
