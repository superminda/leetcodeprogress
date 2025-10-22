// Last updated: 10/22/2025, 12:39:10 AM
class Solution {
    public boolean isBalanced(String num) {
        int balance = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (i % 2 == 0) {
                balance += (c - '0');
            } else {
                balance -= (c - '0');
            }
        }
        return balance == 0;
    }
}