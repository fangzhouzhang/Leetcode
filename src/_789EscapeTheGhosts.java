public class _789EscapeTheGhosts {
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		if (ghosts == null || target == null || target.length < 2) return false;
		int dis = Math.abs(target[0]) + Math.abs(target[1]);
		for (int[] g : ghosts) {
			if (dis >= getDistance(g, target)) return false;
		}
		return true;
	}

	private int getDistance(int[] g, int[] t) {
		return Math.abs(g[0] - t[0]) + Math.abs(g[1] - t[1]);
	}
}
