import java.util.HashSet;
import java.util.Set;

public class _489RobotRoomCleaner {
	private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public void cleanRoom(Robot robot) {
		Set<String> set = new HashSet<>();
		set.add("0-0");
		dfs(robot, set, 0, 0, 0);
	}

	private void dfs(Robot robot, Set<String> set, int row, int col, int dir) {
		robot.clean();

		for (int i = 0; i < 4; i++) {
			int nd = (dir + i) % 4;
			int newRow = row + dirs[nd][0];
			int newCol = col + dirs[nd][1];
			String curDir = newRow + "-" + newCol;
			if (!set.contains(curDir) && robot.move()) {
				set.add(curDir);
				dfs(robot, set, newRow, newCol, nd);
			}
			robot.turnRight();
		}
		setBack(robot);
	}

	private void setBack(Robot robot) {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	private class Robot {
		private boolean move(){
			return false;
		}

		private void turnRight() {
		}

		private void clean() {
		}
	}
}
