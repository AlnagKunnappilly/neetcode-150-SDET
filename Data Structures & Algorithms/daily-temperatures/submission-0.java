class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        	int[] result = new int[temperatures.length];
		Stack<Integer> days = new Stack<>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!days.isEmpty() && temperatures[days.peek()] < temperatures[i]) {
				int previous = days.pop();
				result[previous] = i - previous;
			}
			days.push(i);
		}

		return result;
    }
}
