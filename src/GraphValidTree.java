import java.util.Arrays;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if (n - 1 != edges.length) {
			return false;
		}
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < edges.length; i++) {
			if (uf.find(edges[i][0], edges[i][1])) {
				return false;
			}
			uf.union(edges[i][0], edges[i][1]);
		}
		return uf.num == 1;
	}
	private class UnionFind {
		private int[] parent;
		private int[] size;
		private int num;
		public UnionFind(int m) {
			parent = new int[m];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
			size = new int[m];
			Arrays.fill(size, 1);
			num = m;
		}
		private int root(int idx) {
			int cur = idx;
			while (parent[cur] != cur) {
				parent[cur] = parent[parent[cur]];
				cur = parent[cur];
			}
			parent[idx] = cur;
			return cur;
		}
		private boolean find(int i1, int i2) {
			return root(i1) == root(i2);
		}
		private void union(int i1, int i2) {
			if (find(i1, i2)) {
				return;
			}
			int r1 = root(i1);
			int r2 = root(i2);
			if (size[r1] >= size[r2]) {
				//r1 is root for r2
				parent[r2] = r1;
				size[r1] += size[r2];
			} else {
				parent[r1] = r2;
				size[r2] += size[r1];
			}
			num--;
		}
	}
}
