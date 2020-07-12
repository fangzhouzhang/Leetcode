import java.util.HashSet;
import java.util.Set;

public class _277FindtheCelebrity {
	public int findCelebrity(int n) {
		int[] arr = new int[n];
		Set<Integer> cele = new HashSet<>();
		for (int i = 0; i < n; i++) cele.add(i);
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					arr[i]++;
				} else {
					if (!knows(i, j)) {
						cele.remove(j);
					} else {
						arr[j]++;
						cele.remove(i);
					}
					if (!knows(j, i)) {
						cele.remove(i);
					} else {
						arr[i]++;
						cele.remove(j);
					}
				}
			}
		}
		for (int c : cele) {
			if (arr[c] == n) return c;
		}
		return -1;
	}

	private boolean knows(int i, int j) {
		return false;
	}

}
