import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
	private int sum;
	private int size;
	private Queue<Integer> q = new LinkedList<>();
	/** Initialize your data structure here. */
	public MovingAverageFromDataStream(int size) {
		this.size = size;
		sum = 0;
	}

	public double next(int val) {
		if (q.size() >= size) {
			sum -= q.peek();
			q.poll();
		}
		q.add(val);
		sum += val;
		return sum * 1.0 / q.size();
	}
}
