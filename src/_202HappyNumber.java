import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) return false;
		Set<Integer> set = new HashSet<>();
		while (true) {
			int res = 0;
			while (n != 0) {
				int digit = n % 10;
				res += digit * digit;
				n /= 10;
			}
			if (res == 1) return true;
			if (set.contains(res)) {
				return false;
			} else {
				set.add(res);
				n = res;
			}
		}
	}
}
