public class DivisorGame {
	public boolean divisorGame(int N) {
		Boolean[] mem = new Boolean[N + 1];
		return dfs(mem, N);
	}
	private boolean dfs(Boolean[] mem, int end) {
		if (end == 1) {
			return false;
		}
		if (mem[end] != null) {
			return mem[end];
		}
		for (int i = 1; i < end; i++) {
			if (end % i == 0) {
				if (!dfs(mem, end - i)) {
					mem[end] = true;
					return true;
				}
			}
		}
		mem[end] = false;
		return false;
	}
}
