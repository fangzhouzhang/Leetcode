public class BullsandCows {
	public String getHint(String secret, String guess) {
		int[] arr = new int[10];
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				if (arr[secret.charAt(i) - '0']++ < 0) cows++;
				if (arr[guess.charAt(i) - '0']-- > 0) cows++;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
