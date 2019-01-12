import java.util.HashSet;
import java.util.Set;

public class FindtheCelebrity {
	public int findCelebrity(int n) {
		if (n <= 0) {
			return -1;
		}
		Set<Integer> nonCele = new HashSet<>();
		int candidate = 0;
		while (candidate < n) {
			if (!nonCele.contains(candidate)) {
				if (isValid(candidate, n, nonCele)) {
					return candidate;
				}
			}
			candidate++;
		}
		return -1;
	}
	private boolean isValid(int candidate, int n, Set<Integer> nonCele) {
		for (int i = 0; i < n; i++) {
			if (i == candidate) {
				continue;
			}
			if (knows(candidate, i) == true) {//candidate cannot be celebrity
				nonCele.add(candidate);
				return false;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i == candidate) {
				continue;
			}
			if (knows(i, candidate) == false) {//candidate cannot be celebrity
				nonCele.add(candidate);
				return false;
			}
		}
		return true;
	}
	private boolean knows(int i, int j) {
		return false;
	}
}
