import java.util.Comparator;
import java.util.PriorityQueue;

public class _853CarFleet {
	/**
	 * time : o(nlogn)
	 * @param target
	 * @param position
	 * @param speed
	 * @return
	 */
	public int carFleet(int target, int[] position, int[] speed) {
		if (position == null || speed == null) return -1;
		if (position.length == 0 || speed.length == 0) return 0;
		PriorityQueue<Car> pq = new PriorityQueue<>(new MyComparator());
		for (int i = 0; i < speed.length; i++) {
			double time = (target - position[i]) * 1.0 / speed[i];
			pq.add(new Car(position[i], time));
		}
		int carFleet = 0;
		while (!pq.isEmpty()) {
			Car car = pq.poll();
			while (!pq.isEmpty() && pq.peek().time <= car.time) pq.poll();
			carFleet++;
		}
		return carFleet;
	}

	private class MyComparator implements Comparator<Car> {
		public int compare(Car a, Car b) {
			return b.pos - a.pos;
		}
	}

	private class Car {
		int pos;
		double time;
		public Car(int pos, double time) {
			this.pos = pos;
			this.time = time;
		}
	}
}
