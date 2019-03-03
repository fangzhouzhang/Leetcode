import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();
		UnionFind uf = new UnionFind(m, n);
		//Set<Integer> set = new HashSet<>();
		for (int[] pos: positions) {

			uf.createIsland(pos[0] * n + pos[1]);
			for (int[] dir: dirs) {
				if (isValid(m, n, pos[0] + dir[0], pos[1] + dir[1], uf)) {
					uf.union(pos[0] * n + pos[1], (pos[0] + dir[0]) * n + pos[1] + dir[1]);
				}
			}
			res.add(uf.num);
		}
		return res;
	}
	private boolean isValid(int m, int n, int row, int col, UnionFind uf) {
		if (row < 0 || row >= m) {
			return false;
		}
		if (col < 0 || col >= n) {
			return false;
		}
		if (uf.parent[row * n + col] == -1) {
			return false;
		}

		return true;
	}
	private class UnionFind {
		private int[] size;
		public int[] parent;
		public int num;
		public UnionFind(int m, int n) {
			size = new int[m * n];
			parent = new int[m * n];
			Arrays.fill(parent, -1);
			num = 0;
		}
		//is it able to find same parent for two indices?
		//if two indices has same parent, it is true
		//otherwise false
		private boolean find(int i1, int i2) {
			return root(i1) == root(i2);
		}
		private int root(int idx) {
			int cur = idx;
			//System.out.println(idx);
			if (parent[cur] == -1) {
				return -1;
			}
			while (parent[cur] != cur) {
				parent[cur] = parent[parent[cur]];
				cur = parent[cur];
			}
			parent[idx] = cur;
			return cur;
		}
		private void union(int i1, int i2) {
			if (find(i1, i2) == true) {
				return;
			}
			int r1 = root(i1);
			int r2 = root(i2);
			if (size[r1] > size[r2]) {
				parent[r2] = r1;
				size[r1] += size[r2];
			} else {
				parent[r1] = r2;
				size[r2] += size[r1];
			}
			num--;
		}
		private void createIsland(int idx) {
			if (parent[idx] == -1) {
				num++;
				parent[idx] = idx;
				size[idx] = 1;
			}
		}
	}
}
