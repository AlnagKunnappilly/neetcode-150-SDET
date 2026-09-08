class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        	int right = 0;
		int left = 1;
		for (int pile : piles) {
			right = Math.max(right, pile);
		}

		while (left <= right) {//1<=4
			int mid = left + (right - left) / 2;//2
			long totalHours = 0;
			for (int pile : piles) {
				totalHours += (pile + mid - 1) / mid;//16
			}
			if (totalHours <= h) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
    }
}
