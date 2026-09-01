class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
		HashSet<Character> h = new HashSet<>();
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			while (h.contains(s.charAt(right))) {
				h.remove(s.charAt(left));
				left++;
			}
			h.add(s.charAt(right));

			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
    }
}
