public class ConstructQuadTree {
	public Node construct(int[][] grid) {
		return build(grid, 0, 0, grid.length);
	}

	private Node build(int[][] grid, int x, int y, int len) {
		if (len == 0) {
			return null;
		}
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (grid[i][j] != grid[x][y]) {
					return new Node(false, false,
							build(grid, x, y, len / 2),
							build(grid, x, y + len / 2, len / 2),
							build(grid, x + len / 2, y, len / 2),
							build(grid, x + len / 2, y + len / 2, len / 2));
				}
			}
		}
		return new Node(grid[x][y] == 1, true, null, null, null, null);
	}

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {}

		public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	};
}
