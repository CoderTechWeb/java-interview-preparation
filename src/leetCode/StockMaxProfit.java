package leetCode;

//Best Time to Buy & Sell Stock

import java.util.Map;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class StockMaxProfit {

    static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};

        int min = input[0];
        int maxProfit = 0;

        for(int i:input) {
            min = Math.min(min, i);
            maxProfit = Math.max(maxProfit, i - min);
        }

        System.out.println(maxProfit);
    }
}
