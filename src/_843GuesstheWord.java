import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _843GuesstheWord {
	public void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0, x = 0; i < 10 && x < 6; i++) {
			int idx = new Random().nextInt(wordlist.length);
			x = master.guess(wordlist[idx]);
			List<String> list = new ArrayList<>();
			for (String w : wordlist) {
				if (match(w, wordlist[idx]) == x) list.add(w);
			}

			wordlist = list.toArray(new String[list.size()]);
		}
	}

	private int match(String a, String b) {
		int res = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) res++;
		}
		return res;
	}

	private class Master{
		int guess(String a){
			return 0;
		}
	}
}
