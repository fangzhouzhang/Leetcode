import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarFleet {
	/**
	 * time : o(n)
	 * @param target
	 * @param position
	 * @param speed
	 * @return
	 */
	public int carFleet(int target, int[] position, int[] speed) {
		if (position.length == 0 || speed.length == 0) {
			return 0;
		}
		List<Car> list = new ArrayList<>();
		for (int i = 0; i < position.length; i++) {
			double r = (target - position[i]) * 1.0 / speed[i];
			list.add(new Car(position[i], r));
		}
		Collections.sort(list, new MyComparator());
		int res = 1;
		double t = list.get(0).rem;
		for (int i = 1; i < list.size(); i++) {
			//System.out.println(list.get(i).rem + " ... " + list.get(i - 1).rem);
			if (list.get(i).rem <= t) {
				continue;
			}
			t = list.get(i).rem;
			res++;
		}
		return res;
	}
	private class Car {
		private int position;
		private double rem;
		public Car(int pos, double rem) {
			this.position = pos;
			this.rem = rem;
		}
	}
	private class MyComparator implements Comparator<Car> {
		public int compare(Car c1, Car c2) {
			if (c1.position != c2.position) {
				return c2.position - c1.position;
			} else {
				return (int)(c1.rem - c2.rem);
			}
		}
	}
}
