public class _1822SignoftheProductofanArray {
	public int arraySign(int[] nums) {
		int neg = 0, pos = 0;
		for (int x : nums)
			if (x != 0) {
				if (x < 0) neg++;
				else pos++;
			}
			else return 0;
		return neg % 2 == 0 ? 1 : -1;
	}
}
