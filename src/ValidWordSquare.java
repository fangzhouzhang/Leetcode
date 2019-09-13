import java.util.List;

public class ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
		if (words.size() == 0) {
			return true;
		}
		int n = words.size();
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= n || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
