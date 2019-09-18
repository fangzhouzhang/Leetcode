import java.util.Arrays;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		if (heaters.length == 0) {
			return 0;
		}
		if (houses.length == 0) {
			return 0;
		}
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int res = 0;
		int i = 0;
		for (int h : houses) {
			while (i < heaters.length - 1 && Math.abs(heaters[i] - h) >= Math.abs(heaters[i + 1] - h)) {
				i++;
			}
			res = Math.max(res, Math.abs(heaters[i] - h));
		}
		return res;
	}
}
