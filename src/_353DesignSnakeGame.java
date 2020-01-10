import java.util.*;

public class _353DesignSnakeGame {
	private class SnakeGame {
		private Set<Integer> body;
		private LinkedList<Integer> coords;
		private int ROWS;
		private int COLS;
		private int scores;
		private int foodIdx;
		private int[][] food;
		private Map<String, int[]> map;
		/** Initialize your data structure here.
		 @param width - screen width
		 @param height - screen height
		 @param food - A list of food positions
		 E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
		public SnakeGame(int width, int height, int[][] food) {
			ROWS = height;
			COLS = width;
			this.food = food;
			body = new HashSet<>();
			coords = new LinkedList<>();
			coords.add(0);
			scores = 0;
			foodIdx = 0;
			map = new HashMap<>();
			map.put("R",new int[]{0, 1});
			map.put("L",new int[]{0, -1});
			map.put("U",new int[]{-1, 0});
			map.put("D",new int[]{1, 0});
		}

		/** Moves the snake.
		 @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
		 @return The game's score after the move. Return -1 if game over.
		 Game over when snake crosses the screen boundary or bites its body. */
		public int move(String direction) {
			//if cur pos is food update board
			int[] dir = map.get(direction);
			int r = coords.peekFirst() / COLS  + dir[0];
			int c = coords.peekFirst() % COLS  + dir[1];
			if (r < 0 || r >= ROWS) return -1;
			if (c < 0 || c >= COLS) return -1;
			int last = coords.pollLast();
			body.remove(last);
			if (body.contains(r * COLS + c)) return -1;//bite its own body
			//add new head pos
			coords.addFirst(r * COLS + c);
			body.add(r * COLS + c);
			//is it food available?
			if (foodIdx < food.length && food[foodIdx][0] * COLS + food[foodIdx][1] == r * COLS + c) {
				scores++;
				foodIdx++;
				coords.addLast(last);
			}
			return scores;
		}
	}
}
