public class _1342NumberofStepstoReduceaNumbertoZero {
	public int numberOfSteps (int num) {
		if (num == 0) return 0;
		int step = 0;
		while (num != 0) {
			if (num % 2 == 1) num--;
			else num /= 2;
			step++;
		}
		return step;
	}
}
