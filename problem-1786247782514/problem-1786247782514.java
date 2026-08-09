// Last updated: 8/8/2026, 11:56:22 PM
1class Solution {
2    public double minPrice(int[] prices, int[] discounts) {
3        Arrays.sort(prices);
4        Arrays.sort(discounts);
5        double result = 0.0;
6        int discountIndex = discounts.length - 1;
7        for (int i = prices.length - 1; i >= 0; i--) {
8            if (discountIndex >= 0) {
9                result += 1.0 * prices[i] * (100 - discounts[discountIndex--]) / 100.0;
10            } else {
11                result += prices[i];
12            }
13        }
14        return result;
15    }
16}