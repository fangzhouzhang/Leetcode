public class _1781SumofBeautyofAllSubstrings {
	public int beautySum(String s) {
		if (s == null || s.length() == 0) return 0;
		int n = s.length();
		int max = 0, min = n;
		int[] fre = new int[26];
		for (int i = 0; i < n; i++) {
			int idx = s.charAt(i) - 'a';
			fre[idx]++;
			max = Math.max(max, fre[idx]);
			min = Math.min(min, fre[idx]);
		}
		int diff = max - min, res = 0;
		for (int i = 0; i < n; i++) {
			int[] a = new int[26];
			for (int j = i; j < n; j++) {
				int idx = s.charAt(j) - 'a';
				a[idx]++;
				int curMax = 0, curMin = n;
				for (int k = 0; k < 26; k++) {
					if (a[k] == 0) continue;
					curMax = Math.max(a[k], curMax);
					curMin = Math.min(a[k], curMin);
				}
				if (curMax - curMin != 0) {
					res+=curMax - curMin;
				}
			}
		}
		return res;
	}
}
