// Last updated: 11/1/2025, 11:58:07 PM
class Solution {
    private static long posMax = 100000l;
    private static long negMin = -100000l;
    public long maxProduct(int[] nums) {
        long result = 0l;
        PriorityQueue<Integer> negativeHeap = new PriorityQueue<>(3, (a, b) -> (b - a));
        PriorityQueue<Integer> positiveHeap = new PriorityQueue<>(3, (a, b) -> (a - b));
        int negativeNumCount = 0;
        int zeroNumCount = 0;
        int positiveNumCount = 0;
        for (int num : nums) {
            if (num < 0) {
                negativeHeap.offer(num);
                if (negativeHeap.size() == 4) {
                    negativeHeap.poll();
                }
            } else if (num > 0) {
                positiveHeap.offer(num);
                if (positiveHeap.size() == 4) {
                    positiveHeap.poll();
                }
            } else {
                zeroNumCount++;
            }
        }
        negativeNumCount = negativeHeap.size();
        positiveNumCount = positiveHeap.size();
        if (nums.length - zeroNumCount < 2) {
            return 0;
        } else if (nums.length - zeroNumCount == 2) {
            if (positiveNumCount == 2) {
                return (long)positiveHeap.poll() * (long)positiveHeap.poll() * posMax;
            } else if (positiveNumCount == 1) {
                return (long)positiveHeap.poll() * (long)negativeHeap.poll() * negMin;
            } else {
                return (long)negativeHeap.poll() * (long)negativeHeap.poll() * posMax;
            }
        } else {
            int thirdPos = positiveHeap.size() == 3 ? positiveHeap.poll() : 0;
            int secondPos = positiveHeap.size() == 2 ? positiveHeap.poll() : 0;
            int fistPos = positiveHeap.size() == 1 ? positiveHeap.poll() : 0;
            int thirdNeg = negativeHeap.size() == 3 ? negativeHeap.poll() : 0;
            int secondNeg = negativeHeap.size() == 2 ? negativeHeap.poll() : 0;
            int firstNeg = negativeHeap.size() == 1 ? negativeHeap.poll() : 0;
            // negative * 2, positive * 1
            if (positiveNumCount == 3) {
                if (negativeNumCount == 0) {
                    result = (long)fistPos * secondPos * posMax; 
                } else if (negativeNumCount == 1) {
                    result = Math.max(result, (long)fistPos * secondPos * posMax);
                    result = Math.max(result, (long)fistPos * firstNeg * negMin);
                } else {
                    result = Math.max((long)secondNeg * firstNeg * posMax, (long)fistPos * secondPos * posMax);
                    result = Math.max(result, (long)firstNeg * fistPos * negMin);
                }
            } else if (positiveNumCount == 2) {
                if (negativeNumCount == 1) {
                    result = Math.max((long)fistPos * secondPos * posMax, (long)fistPos * firstNeg * negMin);
                } else {
                    result = Math.max((long)secondNeg * firstNeg * posMax, (long)fistPos * secondPos * posMax);
                    result = Math.max(result, (long)firstNeg * fistPos * negMin);
                }
            } else if (positiveNumCount == 1) {
                if (negativeNumCount == 2) {
                    result = Math.max((long)secondNeg * firstNeg * posMax, (long)fistPos * firstNeg * negMin);
                } else {
                    result = Math.max((long)secondNeg * firstNeg * posMax, (long)fistPos * firstNeg * negMin);
                }
            } else {
                result = (long)secondNeg * firstNeg * posMax;
            }

            return result;
        }
    }
}