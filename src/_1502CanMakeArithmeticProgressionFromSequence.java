import java.util.Arrays;

public class _1502CanMakeArithmeticProgressionFromSequence {
	public boolean canMakeArithmeticProgression(int[] arr) {
		if (arr == null || arr.length == 0) return false;
		Arrays.sort(arr);
		int diff = arr[1] - arr[0];
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] != diff) return false;
		}
		return true;
	}
}
