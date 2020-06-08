import java.util.ArrayList;
import java.util.List;

public class _1472DesignBrowserHistory {
	private class BrowserHistory {
		private int idx = 0;
		private List<String> urls;
		public BrowserHistory(String homepage) {
			urls = new ArrayList<>();
			urls.add(homepage);
			idx++;
		}

		public void visit(String url) {
			while (urls.size() > idx) urls.remove(urls.size() - 1);
			urls.add(url);
			idx++;
		}

		public String back(int steps) {

			if (idx - steps - 1 >= 0) {
				String res = urls.get(idx - steps - 1);
				idx = idx - steps;
				return res;
			} else {
				String res = urls.get(0);
				idx = 1;
				return res;
			}
		}

		public String forward(int steps) {
			if (idx + steps - 1 < urls.size()) {
				String res = urls.get(idx + steps - 1);
				idx = idx + steps;
				return res;
			} else {
				String res = urls.get(urls.size() - 1);
				idx = urls.size();
				return res;
			}
		}
	}
}
