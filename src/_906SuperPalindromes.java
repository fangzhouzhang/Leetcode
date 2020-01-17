public class _906SuperPalindromes {
	public int superpalindromesInRange(String L, String R) {
		if (L == null || R == null) return 0;
		long lower = Long.valueOf(L);
		long upper = Long.valueOf(R);
		int start = Math.max(1, (int)Math.pow(10, L.length()/4 - 1));
		int end = (int)Math.pow(10, R.length()/4 + 1);
		int res = 0;
		for (int i = start; i <= end; i++) {
			for (int j = 0; j <= 1; j++) {
				long palin = getPalin(i, j);
				long superPalin = palin * palin;
				if (superPalin >= lower && superPalin <= upper && isPalin(superPalin)) res++;
			}
		}
		return res;
	}

	private long getPalin(int i, int j) {
		long tmp = i;
		if (j == 1) {
			i /= 10;
		}

		while (i != 0) {
			tmp = tmp * 10 + (i % 10);
			i /= 10;
		}
		return tmp;
	}

	private boolean isPalin(long num) {
		StringBuilder sb = new StringBuilder();
		long cur = num;
		while (cur != 0) {
			sb.append(cur % 10);
			cur /= 10;
		}
		return (num + "").equals(new String(sb));
	}
}
