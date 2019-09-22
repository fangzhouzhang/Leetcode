import java.util.*;

public class DesignInMemoryFileSystem {
	TrieNode root;
	public FileSystem() {
		root = new TrieNode();
	}

	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		TrieNode cur = root;
		List<String> res = new ArrayList<>();
		String name = "";
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!cur.children.containsKey(dir)) {
				return res;
			}
			cur = cur.children.get(dir);
			name = dir;
		}
		if (cur.isFile) res.add(name);
		else {
			for (Map.Entry<String, TrieNode> e : cur.children.entrySet()) {
				res.add(e.getKey());
			}
		}
		Collections.sort(res);
		return res;
	}

	public void mkdir(String path) {
		String[] dirs = path.split("/");
		TrieNode cur = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!cur.children.containsKey(dir)) {
				cur.children.put(dir, new TrieNode());
			}
			cur = cur.children.get(dir);
		}
	}

	public void addContentToFile(String filePath, String content) {
		String[] dirs = filePath.split("/");
		TrieNode cur = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!cur.children.containsKey(dir)) {
				cur.children.put(dir, new TrieNode());
			}
			cur = cur.children.get(dir);
		}
		cur.isFile = true;
		cur.content += content;
	}

	public String readContentFromFile(String filePath) {
		String[] dirs = filePath.split("/");
		TrieNode cur = root;
		for (String dir : dirs) {
			if (dir.length() == 0) continue;
			if (!cur.children.containsKey(dir)) {
				return "";
			}
			cur = cur.children.get(dir);
		}
		return cur.content;
	}

	private class TrieNode {
		Map<String, TrieNode> children;
		boolean isFile;
		String content;
		public TrieNode() {
			children = new HashMap<>();
			isFile = false;
			content = "";
		}
	}
}
