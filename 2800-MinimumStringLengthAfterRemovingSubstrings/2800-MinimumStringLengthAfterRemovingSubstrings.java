// Last updated: 10/22/2025, 12:40:15 AM
class Solution {
    public int minLength(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == 'B' || c == 'D') {
                if (!stack.isEmpty()) {
                    if (c == 'B' && stack.peek() == 'A') {
                        stack.pop();
                        continue;
                    } else if (c == 'D' && stack.peek() == 'C') {
                        stack.pop();
                        continue;
                    }
                }
            }
            stack.push(c);
        }
        return stack.size();
    }
}