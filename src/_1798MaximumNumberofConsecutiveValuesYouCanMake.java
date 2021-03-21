import java.util.Arrays;

public class _1798MaximumNumberofConsecutiveValuesYouCanMake {
	public int getMaximumConsecutive(int[] coins) {
		Arrays.sort(coins);
		int res = 0;
		for (int coin : coins) {
			if (coin > res + 1) return res + 1;
			res += coin;
		}
		return res + 1;
	}
}
