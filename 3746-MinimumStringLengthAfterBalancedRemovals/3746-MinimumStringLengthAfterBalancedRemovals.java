// Last updated: 11/15/2025, 11:15:59 PM
class Solution {
    public int minLengthAfterRemovals(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c != stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }
}