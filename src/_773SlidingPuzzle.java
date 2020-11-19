import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _773SlidingPuzzle {
	private int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
	public int slidingPuzzle(int[][] board) {
		Set<String> set = new HashSet<>();
		char[] des = {'1', '2', '3', '4', '5', '0'};
		char[] start = new char[6];
		int idx = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				start[idx++] = (char)(board[i][j] + '0');
			}
		}
		Queue<char[]> q = new LinkedList<>();
		q.add(start);
		set.add(new String(start));
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				char[] cur = q.poll();
				boolean finish = true;
				for (int i = 0; i < 6; i++) {
					if (cur[i] != des[i]) {
						finish = false;
						break;
					}
				}
				if (finish) return step;
				int zeroIdx = getIdx(cur);
				for (int swapIdx : dirs[zeroIdx]) {
					swap(cur, zeroIdx, swapIdx);
					String state = new String(cur);
					if (!set.contains(state)) {
						q.add(state.toCharArray());
						set.add(state);
					}
					swap(cur, zeroIdx, swapIdx);
				}
			}
			step++;
		}
		return -1;
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private int getIdx(char[] a) {
		for (int i = 0; i < 6; i++) {
			if (a[i] == '0') return i;
		}
		return -1;
	}
}
