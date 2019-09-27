import java.util.HashSet;
import java.util.Set;

public class FloodFill {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private Set<Integer> set = new HashSet<Integer>();
	private int prev;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		prev = image[sr][sc];
		dfs(image, sr, sc, newColor);
		return image;
	}

	private void dfs(int[][] image, int r, int c, int color) {
		if (image[r][c] != prev) return;
		image[r][c] = color;
		set.add(r * image[r].length + c);
		for (int[] dir : dirs) {
			if (inbound(image, r + dir[0], c + dir[1])) {
				int tmp = (r + dir[0]) * image[r].length + (c + dir[1]);
				if (!set.contains(tmp)) {
					dfs(image, r + dir[0], c + dir[1], color);
				}
			}
		}
	}

	private boolean inbound(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length) {
			return false;
		}
		if (col < 0 || col >= grid[0].length) {
			return false;
		}
		return true;
	}
}
