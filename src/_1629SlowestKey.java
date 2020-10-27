public class _1629SlowestKey {
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		if (keysPressed.length() == 1) return keysPressed.charAt(0);
		int maxf = releaseTimes[0];
		char maxc = keysPressed.charAt(0);
		for (int i = 1; i < keysPressed.length(); i++) {
			if (maxf < releaseTimes[i] - releaseTimes[i - 1]) {
				maxf = releaseTimes[i] - releaseTimes[i - 1];
				maxc = keysPressed.charAt(i);
			} else if (maxf == releaseTimes[i] - releaseTimes[i - 1]) {
				if (keysPressed.charAt(i) > maxc) {
					maxc = keysPressed.charAt(i);
				}
			}
		}
		return maxc;
	}
}
