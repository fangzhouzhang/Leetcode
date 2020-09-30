public class _1523CountOddNumbersinanIntervalRange {
	public int countOdds(int low, int high) {
		if (low % 2 == 0 && high % 2 == 0) {
			return (high - low + 1) / 2;
			// 2 4
		} else if (low % 2 == 0 && high % 2 == 1) {
			return (high - low + 1) / 2;
			// 2 5
		} else if (low % 2 == 1 && high % 2 == 1) {
			return  (high - low + 1) / 2 + 1;
			// 1 3
		} else {
			//
			return (high - low + 1) / 2;
		}
	}
}
