import java.util.HashSet;
import java.util.Set;

public class _1346CheckIfNandItsDoubleExist {
	public boolean checkIfExist(int[] arr) {
		if (arr == null || arr.length == 0) return false;
		Set<Integer> set = new HashSet<>();
		for (int n : arr) {
			if (set.contains(n * 2)) return true;
			if (n % 2 == 0) {
				if (set.contains(n / 2)) return true;
			}
			set.add(n);
		}
		return false;
	}
}
