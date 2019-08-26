import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int square = 0;
		int remain = 0;
		while (set.add(n)) {
			while (n > 0) {
				remain = n % 10;
				square += remain * remain;
				n /= 10;
			}
			if (square == 1) {
				return true;
			} else {
				n = square;
				square = 0;
			}
		}
		return false;
	}
}
