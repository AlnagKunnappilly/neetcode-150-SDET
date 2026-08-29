class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> num = new HashSet<>();
		for (int n : nums) {
			num.add(n);
		}
		int longest = 0;
		for (int n : num) {

			if (!num.contains(n - 1)) {
				int count = 1;
				int current = n;

				while (num.contains(current + 1)) {
					count++;
					current++;
				}
				longest = Math.max(longest, count);
			}
		}
		return longest;
    }
}
