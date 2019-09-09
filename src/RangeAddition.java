public class RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] tmp = new int[length + 1];
		for (int[] update : updates) {
			tmp[update[0]] += update[2];
			tmp[update[1] + 1] -= update[2];
		}
		int sum = 0;
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			sum += tmp[i];
			res[i] = sum;
		}
		return res;
	}
}
