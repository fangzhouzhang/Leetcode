public class _1812DetermineColorofaChessboardSquare {
	public boolean squareIsWhite(String coordinates) {
		if (coordinates.charAt(0) == 'a' || coordinates.charAt(0) == 'c' || coordinates.charAt(0) == 'e' || coordinates.charAt(0) == 'g') {
			if ((coordinates.charAt(1) - '0') % 2 == 1) return false;
			else return true;
		} else {
			if ((coordinates.charAt(1) - '0') % 2 == 1) return true;
			else return false;
		}
	}
}
