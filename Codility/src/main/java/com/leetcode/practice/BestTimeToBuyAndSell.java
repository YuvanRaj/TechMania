package com.leetcode.practice;

public class BestTimeToBuyAndSell {

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

		int[] prices2 = new int[] { 1 };
		System.out.println(maxProfit(prices2));

	}

	/**
	 Logical pseudocode:
		
		1. Check the stock price is increased from start of the array
		2. If the stock price is increased from previous value find the difference of that(Profit).
		3. Repeat the above step each element in that array (To Repeat the same for all elements use for Loop)
		
		
		Time complexity= O(n2)
		Space Complexity = O(1)
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if(prices.length ==1)
			return 0;
		
		int diff = 0;
		int profit = -1;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] < prices[j]) {
					diff = prices[j] - prices[i];
				}

				if (diff > profit)
					profit = diff;
			}
		}
		return profit;
	}
}
