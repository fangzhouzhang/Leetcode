public class _1732FindtheHighestAltitude {
	public int largestAltitude(int[] gain) {
		int max = 0;
		int h = 0;
		for (int i = 0; i < gain.length; i++) {
			h += gain[i];
			max = Math.max(max, h);
		}
		return max;
	}
}
