import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids.length == 0) return new int[0];
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < asteroids.length) {
			if (stack.isEmpty() || asteroids[i] * stack.peek() > 0 || (stack.peek() < 0 && asteroids[i] > 0)) stack.push(asteroids[i++]);
			else {
				while (!stack.isEmpty() && (stack.peek() >= 0 && asteroids[i] <= 0) && Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
					stack.pop();
				}
				if (!stack.isEmpty() && (stack.peek() >= 0 && asteroids[i] <= 0)) {
					if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
						i++;
					} else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
						stack.pop();
						i++;
					}
				}
			}
		}
		int[] res = new int[stack.size()];
		for (int i1 = res.length - 1; i1 >= 0; i1--) res[i1] = stack.pop();
		return res;
	}
}
