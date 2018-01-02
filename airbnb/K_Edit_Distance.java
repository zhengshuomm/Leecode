import java.util.ArrayList;
import java.util.List;

public class K_Edit_Distance {
	private void search(String curr, String target, int k, TrieNode root, int[] prevDist, List<String> result) {
		if (root.isLeaf) {
			if (prevDist[target.length()] <= k) {
				result.add(curr);
			} else {
				return;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (root.children[i] == null) {
				continue;
			}
			int[] currDist = new int[target.length() + 1];
			currDist[0] = curr.length() + 1;
			for (int j = 1; j < prevDist.length; j++) {
				if (target.charAt(j - 1) == (char) (i + 'a')) {
					currDist[j] = prevDist[j - 1];
				} else {
					currDist[j] = Math.min(Math.min(prevDist[j - 1], prevDist[j]), currDist[j - 1]) + 1;
				}
			}
			search(curr + (char) (i + 'a'), target, k, root.children[i], currDist, result);
		}
	}

	public List<String> getKEditDistance(String[] words, String target, int k) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0 || target == null || target.length() == 0 || k < 0) {
			return res;
		}
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		TrieNode root = trie.root;
		// The edit distance from curr to target
		int[] prev = new int[target.length() + 1];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = i;
		}
		search("", target, k, root, prev, res);
		return res;
	}

	class TrieNode {
		TrieNode[] children;
		boolean isLeaf;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Add a word into trie
		public void insert(String s) {
			if (s == null || s.length() == 0) {
				return;
			}
			TrieNode p = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (p.children[c - 'a'] == null) {
					p.children[c - 'a'] = new TrieNode();
				}
				if (i == s.length() - 1) {
					p.children[c - 'a'].isLeaf = true;
				}
				p = p.children[c - 'a'];
			}
		}
	}
}
