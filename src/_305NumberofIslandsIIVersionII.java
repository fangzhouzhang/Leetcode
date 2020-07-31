import java.util.ArrayList;
import java.util.List;

public class _305NumberofIslandsIIVersionII {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();
		UnionFind uf = new UnionFind(m, n);
		for (int[] p : positions) {
			uf.init(p[0], p[1]);
			for (int[] dir : dirs) {
				int x = p[0] + dir[0];
				int y = p[1] + dir[1];
				if (!isValid(x, y, m, n, uf)) continue;
				uf.union(p[0], p[1], x, y);
			}
			res.add(uf.count);
		}
		return res;
	}

	private boolean isValid(int i, int j, int m, int n, UnionFind uf) {
		if (i < 0 || i >= m) return false;
		if (j < 0 || j >= n) return false;
		if (uf.parent[i][j] == -1) return false;
		return true;
	}

	private class UnionFind {
		int[][] parent;
		int[][] size;
		int cols;
		int count;
		public UnionFind(int m, int n) {
			cols = n;
			count = 0;
			parent = new int[m][n];
			size = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					parent[i][j] = -1;
					size[i][j] = 0;
				}
			}
		}

		public void init(int x, int y) {
			if (parent[x][y] == -1) {
				count++;
				parent[x][y] = x * cols + y;
				size[x][y] = 1;
			}
		}

		public int getParent(int i, int j) {
			if (parent[i][j] == i * cols + j) return i * cols + j;
			parent[i][j] = getParent(parent[i][j] / cols, parent[i][j] % cols);
			return parent[i][j];
		}

		public void union(int x1, int y1, int x2, int y2) {
			int rootA = getParent(x1, y1);
			int rootB = getParent(x2, y2);
			if (rootA == -1 || rootB == -1) return;
			if (rootA == rootB) return;
			if (size[rootA / cols][rootA % cols] > size[rootB / cols][rootB % cols]) {
				parent[rootB / cols][rootB % cols] = rootA;
			} else if (size[rootA / cols][rootA % cols] < size[rootB / cols][rootB % cols]) {
				parent[rootA / cols][rootA % cols] = rootB;
			} else {
				parent[rootA / cols][rootA % cols] = rootB;
				size[rootB / cols][rootB % cols]++;
			}
			count--;
		}
	}
}
