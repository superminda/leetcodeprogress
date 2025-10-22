// Last updated: 10/22/2025, 12:39:04 AM
class NodeInfo {
    char c;
    int leftContinousCount;
    int rightContinousCount;
    public NodeInfo(char c, int leftContinousCount, int rightContinousCount) {
        this.c = c;
        this.leftContinousCount = leftContinousCount;
        this.rightContinousCount = rightContinousCount;
    }
}

class Solution {
    public String removeSubstring(String s, int k) {
        Stack<NodeInfo> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                if (stack.isEmpty()) {
                    stack.push(new NodeInfo('(', 1, 0));
                } else {
                    NodeInfo prevNode = stack.peek();
                    if (prevNode.c == '(') {
                        stack.push(new NodeInfo('(', prevNode.leftContinousCount + 1, prevNode.rightContinousCount));
                    } else {
                        stack.push(new NodeInfo('(', 1, prevNode.rightContinousCount));
                    }
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(new NodeInfo(')', 0, 1));
                } else {
                    NodeInfo prevNode = stack.peek();
                    if (prevNode.c == '(') {
                        if (k == 1) {
                            stack.pop();
                            continue;
                        } else {
                            stack.push(new NodeInfo(')', prevNode.leftContinousCount, 1));
                        }
                    } else {
                        if (prevNode.leftContinousCount >= k && prevNode.rightContinousCount == k - 1) {
                            for (int count = 0; count < 2 * k - 1; count++) {
                                stack.pop();
                            }
                            continue;
                        }
                        stack.push(new NodeInfo(')', prevNode.leftContinousCount, prevNode.rightContinousCount + 1));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }
}