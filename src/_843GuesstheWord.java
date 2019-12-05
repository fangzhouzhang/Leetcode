import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _843GuesstheWord {
	public void findSecretWord(String[] wordlist, Master master) {
		if (wordlist == null || wordlist.length == 0) return;
		for (int i = 0; i < 10; i++) {
			int idx = new Random().nextInt(wordlist.length);
			int x = master.guess(wordlist[idx]);
			List<String> tmp = new ArrayList<>();
			for (String word : wordlist) {
				if (match(word, wordlist[idx], x)) tmp.add(word);
			}
			wordlist = tmp.toArray(new String[tmp.size()]);
		}
	}

	private boolean match(String a, String b, int x) {
		int res = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) res++;
			if (res > x) return false;
		}
		return res == x;
	}

	private class Master{
		int guess(String a){
			return 0;
		}
	}
}
