public class _1518WaterBottles {
	public int numWaterBottles(int numBottles, int numExchange) {
		int res = numBottles;
		int canChange = numBottles;
		while (canChange >= numExchange) {
			res += canChange / numExchange;
			canChange = canChange / numExchange + canChange % numExchange;
		}
		return res;
	}
}
