import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) return false;
		Set<Integer> set = new HashSet<>();
		while (n != 1) {
			int sum = 0;
			int current = n;
			while (current != 0) {
				sum += (current % 10) * (current % 10);
				current /= 10;
			}
			if (set.contains(sum)) return false;
			set.add(sum);
			n = sum;
		}
		return true;
	}
}
