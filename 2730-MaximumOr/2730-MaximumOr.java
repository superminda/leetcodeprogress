// Last updated: 10/22/2025, 12:40:26 AM
class Solution {
    public long maximumOr(int[] nums, int k) {
        long result = 0L;
        Arrays.sort(nums);
        int restVal = 0;
        int lastIndex = nums.length - 1;
        int maxLen = Integer.toBinaryString(nums[nums.length - 1]).length();
        int[] counts = new int[64];
        for (int i = nums.length - 1; i >= 0; i--) {
            String str = Integer.toBinaryString(nums[i]);
            if (str.length() == maxLen) {
                for (int index = str.length() - 1; index >= 0; index--) {
                    char c = str.charAt(index);
                    if (c == '1') {
                        counts[counts.length - 1 - (str.length() - 1 - index)]++;
                    }
                }
                lastIndex = i;
            } else {
                for (int index = i; index >= 0; index--) {
                    restVal |= nums[index];
                }
                break;
            }
        }
        for (int i = nums.length - 1; i >= lastIndex; i--) {
            long thisResult = restVal;
            thisResult |= ((long)nums[i] << k);
            String str = Integer.toBinaryString(nums[i]);
            int[] newCounts = Arrays.copyOf(counts, 64);
            for (int index = str.length() - 1; index >= 0; index--) {
                char c = str.charAt(index);
                if (c == '1') {
                    newCounts[newCounts.length - 1 - (str.length() - 1 - index)]--;
                }
            }
            long tempCounts = 0L;
            for (int index = 0; index < newCounts.length; index++) {
                tempCounts = 2 * tempCounts + (newCounts[index] > 0 ? 1 : 0);
            }
            thisResult |= tempCounts;
            result = Math.max(result, thisResult);
        }
        return result;
    }
}