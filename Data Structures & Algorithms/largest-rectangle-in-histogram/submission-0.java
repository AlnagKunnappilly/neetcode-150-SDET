class Solution {
    public int largestRectangleArea(int[] heights) {
       int maxarea = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i <= heights.length; i++) {
			int currentHeight = (i == heights.length) ? 0 : heights[i];
			while ((!st.isEmpty()) && (currentHeight < heights[st.peek()])) {

				int height = heights[st.pop()];
				int width;

				if (st.isEmpty()) {
					width = i;
				} else {
					width = i - st.peek() - 1;
				}
				maxarea = Math.max(maxarea, height * width);
			}
			if (i < heights.length) {
				st.push(i);
			}
		}
		return maxarea; 
    }
}
