public class _679_24Game {
	private double ERROR = 1e-6;
	public boolean judgePoint24(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
		return dfs(a);
	}

	private boolean dfs(double[] a) {
		if (a.length == 1) {
			if (Math.abs(a[0] - 24) <= ERROR) return true;
			return false;
		}
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				double[] b = new double[n - 1];
				int idx = 0;
				for (int k = 0; k < n; k++) {
					if (k != i && k != j) b[idx++] = a[k];
				}
				for (double num : compute(a[i], a[j])) {
					b[idx] = num;
					if (dfs(b)) return true;
				}
			}
		}
		return false;
	}

	private double[] compute(double a, double b) {
		return new double[]{a + b, a * b, a - b, b - a, a / b, b / a};
	}
}
