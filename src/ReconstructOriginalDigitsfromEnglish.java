public class ReconstructOriginalDigitsfromEnglish {
	public String originalDigits(String s) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		int[] nums = new int[10];
		nums[0] = counts['z' - 'a'];
		nums[2] = counts['w' - 'a'];
		nums[4] = counts['u' - 'a'];
		nums[6] = counts['x' - 'a'];
		nums[8] = counts['g' - 'a'];
		nums[1] = counts['o' - 'a'] - nums[0] - nums[2] - nums[4];
		nums[3] = counts['h' - 'a'] - nums[8];
		nums[5] = counts['f' - 'a'] - nums[4];
		nums[7] = counts['s' - 'a'] - nums[6];
		nums[9] = counts['i' - 'a'] - nums[6] - nums[8] - nums[5];
		// System.out.println(nums[0]);
		String res = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < nums[i]; j++) {
				res += i + "";
			}
		}
		return res;
	}
}
