class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

		HashMap<String, List<String>> hp = new HashMap<String, List<String>>();

		for (String s : strs) {
			int[] freq = new int[26];
			for (char c : s.toCharArray()) {
				freq[c - 'a']++;
			}

			String key = Arrays.toString(freq);

			if (!hp.containsKey(key)) {
				hp.put(key, new ArrayList<>());
			}
			hp.get(key).add(s);
		}

		return new ArrayList<>(hp.values());
    }
}
