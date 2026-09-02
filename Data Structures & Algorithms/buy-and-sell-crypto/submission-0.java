class Solution {
    public int maxProfit(int[] prices) {
        int sp_Start = 0;
		int maxProfit = 0;
		for (int sp_Moving = 0; sp_Moving < prices.length; sp_Moving++) {
			if(prices[sp_Start] > prices[sp_Moving]) {
				sp_Start = sp_Moving;
			}
			maxProfit = Math.max(maxProfit, prices[sp_Moving] - prices[sp_Start]);

		}

		return maxProfit;
    }
}
