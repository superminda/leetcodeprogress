// Last updated: 10/26/2025, 2:45:58 PM
class ExecutionDetail {
    public int id;
    public int start;
    public int delay;
    public ExecutionDetail(int id, int start) {
        this.id = id;
        this.start = start;
        this.delay = 0;
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<ExecutionDetail> stack = new Stack<>();
        for (String log : logs) {
            String[] parts = log.split(":");
            int thisId = Integer.valueOf(parts[0]);
            boolean isStart = parts[1].equals("start");
            int timestamp = Integer.valueOf(parts[2]);
            if (isStart) {
                stack.push(new ExecutionDetail(thisId, timestamp));
            } else {
                ExecutionDetail thisExecution = stack.pop();
                int executionTime = timestamp - thisExecution.start + 1 - thisExecution.delay;
                result[thisId] += executionTime;
                if (!stack.isEmpty()) {
                    int overallLatency = timestamp - thisExecution.start + 1;
                    stack.peek().delay += overallLatency;
                }
            }
        }
        return result;
    }
}