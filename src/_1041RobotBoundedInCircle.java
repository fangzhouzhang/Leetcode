public class _1041RobotBoundedInCircle {
	public boolean isRobotBounded(String instructions) {
		if (instructions == null || instructions.length() == 0) return true;
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int x = 0, y = 0, i = 0;
		char[] arr = instructions.toCharArray();
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == 'R') {
				i = (i + 1) % 4;
			} else if (arr[k] == 'L') {
				i = (i + 3) % 4;
			} else {
				x += dirs[i][0];
				y += dirs[i][1];
			}
		}
		return (x == 0 && y == 0) || i > 0;
	}
}
