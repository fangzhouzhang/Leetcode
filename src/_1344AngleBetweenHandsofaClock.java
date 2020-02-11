public class _1344AngleBetweenHandsofaClock {
	private int UNIT = 6;
	public double angleClock(int hour, int minutes) {
		double hour_percentage = minutes * 1.0 / 60;
		double hour_degree = hour % 12 * UNIT * 5 + hour_percentage * UNIT * 5;
		double minute_degree = minutes * UNIT;
		return Math.min(Math.abs(hour_degree - minute_degree), 360 - Math.abs(hour_degree - minute_degree));
	}
}
