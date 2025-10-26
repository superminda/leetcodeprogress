// Last updated: 10/26/2025, 7:28:43 PM
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char popChar = stack.pop();
                if (c == ')' && popChar != '(') {
                    return false;
                }
                if (c == ']' && popChar != '[') {
                    return false;
                }
                if (c == '}' && popChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}