class Solution {
    public String minWindow(String s, String t) {
        
		if (t.length() > s.length()) {
			return "";
		}
		HashMap<Character, Integer> required = new HashMap<>();
		for (char c: t.toCharArray()) {
			required.put(c, required.getOrDefault(c, 0) + 1);
		}
		int left = 0;
		int minLen = Integer.MAX_VALUE;
		int minLeft=0;
		int have = 0;
		int need = required.size();
		HashMap<Character, Integer> window = new HashMap<>();

		for (int right = 0; right < s.length(); right++) {

			char c = s.charAt(right);
			window.put(c, window.getOrDefault(c, 0) + 1);

			if (required.containsKey(c) && window.get(c)
					.equals(required.get(c))) {
				have++;
			}

			while (have == need) {

				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					minLeft = left;
				}
				char leftChar = s.charAt(left);
				window.put(leftChar, window.get(leftChar) - 1);

				if (required.containsKey(leftChar) && window.get(leftChar) 
						< required.get(leftChar)) {
					have--;
				}
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? ""
				: s.substring(minLeft, minLeft + minLen);
    }
}
