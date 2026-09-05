class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
		int[] maxArray = new int[nums.length - k + 1];
		int count = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int right = 0; right < nums.length; right++) {

			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
				dq.pollLast();
			}

			dq.offerLast(right);

			if (dq.peekFirst() < left) {
				dq.pollFirst();
			}

			if (right - left + 1 == k) {
				maxArray[count] = nums[dq.peekFirst()];
				count++;
				left++;
			}
		}
		return maxArray;
    }
}
