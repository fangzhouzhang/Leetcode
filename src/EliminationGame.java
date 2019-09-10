public class EliminationGame {
	public int lastRemaining(int n) {
		int head = 1;
		int step = 1;
		int rem = n;
		boolean left = true;
		while (rem > 1) {
			if (left || rem % 2 == 1) {
				head += step;
			}
			rem /= 2;
			step *= 2;
			left = !left;
		}
		return head;
	}
}
