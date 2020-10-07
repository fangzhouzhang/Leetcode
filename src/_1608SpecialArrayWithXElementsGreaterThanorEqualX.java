public class _1608SpecialArrayWithXElementsGreaterThanorEqualX {
	public int specialArray(int[] nums) {
		int[] count = new int[1001];
		for (int n : nums) {
			count[n]++;
		}
		for (int i = 0; i <= 1000; i++) {
			int c = 0;
			int j = i;
			while (j <= 1000) {
				c += count[j];
				if (c > i) break;
				j++;
			}
			if (c == i) return i;
		}
		return -1;
	}
}
