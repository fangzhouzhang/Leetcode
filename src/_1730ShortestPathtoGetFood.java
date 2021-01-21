import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1730ShortestPathtoGetFood {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	int R = 0;
	int C = 0;
	public int getFood(char[][] grid) {
		int x = 0, y = 0;
		R = grid.length;
		C = grid[0].length;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == '*') {
					x = i;
					y = j;
					break;
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(x * C + y);
		Set<Integer> set = new HashSet<>();
		set.add(x * C + y);
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				int r = cur / C;
				int c = cur % C;
				if (grid[r][c] == '#') return res;
				for (int[] dir : dirs) {
					int rr = dir[0] + r;
					int cc = dir[1] + c;
					if (rr < 0 || rr >= R || cc < 0 || cc >= C) continue;
					if (grid[rr][cc] == 'X') continue;
					if (set.contains(rr * C + cc)) continue;
					q.add(rr * C + cc);
					set.add(rr * C + cc);
				}
			}
			res++;
		}
		return -1;
	}
}
