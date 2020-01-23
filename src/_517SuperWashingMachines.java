public class _517SuperWashingMachines {
	public int findMinMoves(int[] machines) {
		if (machines == null || machines.length == 0) return -1;
		int sum = 0;
		for (int m : machines) sum += m;
		if (sum % machines.length != 0) return -1;
		int avg = sum / machines.length;
		int[] prefix = new int[machines.length + 1];
		int s = 0;
		for (int i = 0; i < machines.length; i++) {
			s += machines[i];
			prefix[i + 1] = s;
		}
		int max = 0;
		for (int i = 0; i < machines.length; i++) {
			int left = prefix[i - 1 + 1] - prefix[0];
			int right = prefix[machines.length] - prefix[i + 1];
			int l = left < avg * i ? avg * i - left : 0;
			int r = right < avg * (machines.length - i - 1) ? avg * (machines.length - i - 1) - right : 0;
			max = Math.max(max, l + r);
		}
		return max;
	}
}
