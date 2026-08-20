# Best Time to Buy and Sell Stock

A highly efficient Java solution for the classic "Best Time to Buy and Sell Stock" problem (LeetCode #121). This repository contains an optimized $O(n)$ time complexity approach utilizing a single-pass greedy algorithm.

## 📌 Problem Description

You are given an array `prices` where `prices[i]` is the price of a given stock on the $i^{th}$ day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return the *maximum profit* you can achieve from this transaction. If you cannot achieve any profit, return `0`.

### Examples

**Example 1:**
* **Input:** `prices = [7, 1, 5, 3, 6, 4]`
* **Output:** `5`
* **Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = `6 - 1 = 5`. Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

**Example 2:**
* **Input:** `prices = [7, 6, 4, 3, 1]`
* **Output:** `0`
* **Explanation:** In this case, no transactions are done and the max profit = `0`.

### Constraints
* `1 <= prices.length <= 10^5`
* `0 <= prices[i] <= 10^4`

---

## 🚀 Solution Approach

Instead of using a brute-force method that compares every single pair of days—which results in a slow $O(n^2)$ time complexity—this solution uses a **Greedy Single-Pass** approach.

As we iterate through the array chronologically, we track two critical variables:
1. **`minPrice`**: The lowest price encountered so far.
2. **`maxProfit`**: The maximum difference between the current price and the `minPrice`.

This allows us to solve the problem by looking at each element exactly once.

### Complexity Analysis

| Metric | Complexity | Description |
| :--- | :--- | :--- |
| **Time Complexity** | $O(n)$ | The algorithm iterates through the `prices` array exactly once, where $n$ is the number of days. |
| **Space Complexity** | $O(1)$ | No additional data structures are allocated. Memory usage remains constant regardless of the array size. |

---

## 💻 Code Structure

The core implementation is written in **Java**:

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Calculate potential profit and update max profit if it's higher
            else {
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        
        return maxProfit;
    }
}