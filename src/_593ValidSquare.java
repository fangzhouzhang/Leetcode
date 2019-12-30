import java.util.HashSet;
import java.util.Set;

public class _593ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] a = new int[][]{p1, p2, p3, p4};
		Set<Long> set = new HashSet<>();
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				long dis = (long)((a[i][0] - a[j][0]) * (a[i][0] - a[j][0]) + (a[i][1] - a[j][1]) * (a[i][1] - a[j][1]));
				if (dis == 0) return false;
				set.add(dis);
			}
		}
		return set.size() == 2;
	}
}
