class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
		int left = 0;
		int right = heights.length - 1;
		while (left < right) {
			int height = Math.min(heights[left], heights[right]);
			int width = right - left;
			int areas = height * width;
			area = Math.max(area, areas);
			if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}

		}
		return area;
    }
}
