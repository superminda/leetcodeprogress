// Last updated: 10/28/2025, 12:18:09 AM
class PositionInfo {
    public final char c;
    public final int index;
    public PositionInfo(char c, int index) {
        this.c = c;
        this.index = index;
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        Stack<PositionInfo> stack = new Stack<>();
        for (int index = 0; index < charArray.length; index++) {
            char thisChar = charArray[index];
            if (thisChar == '(') {
                if (!stack.isEmpty()) {
                    PositionInfo prevPos = stack.peek();
                    result = Math.max(result, index - 1 - prevPos.index);
                } else {
                    result = Math.max(index, result);
                }
                stack.push(new PositionInfo(thisChar, index));
            } else {
                if (!stack.isEmpty()) {
                    PositionInfo prevPos = stack.peek();
                    if (prevPos.c == '(') {
                        stack.pop();                
                        if (!stack.isEmpty()) {
                            PositionInfo currentPrevPos = stack.peek();
                            result = Math.max(result, index - currentPrevPos.index);
                        } else {
                            result = index + 1;
                        }
                    } else {
                        stack.push(new PositionInfo(thisChar, index));
                    }
                } else {
                    result = Math.max(index, result);
                    stack.push(new PositionInfo(thisChar, index));
                }
            }
        }
        return result;
    }
}