import java.util.LinkedList;
import java.util.Queue;

public class _346MovingAverageFromDataStream {
	class MovingAverage {
		private Queue<Integer> q;
		private int size;
		private long sum;
		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			q = new LinkedList<>();
			this.size = size;
		}

		public double next(int val) {
			if (q.size() >= this.size) sum -= q.poll();
			q.add(val);
			sum += val;
			return sum * 1.0 / q.size();
		}
	}
}
