// Last updated: 10/22/2025, 12:39:17 AM
class Solution {
    public int maxSum(int[] nums) {
        int result = -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int thisMaxDigit = getMaxDigit(num);
            if (!map.containsKey(thisMaxDigit)) {
                map.put(thisMaxDigit, new ArrayList<>());
            }
            map.get(thisMaxDigit).add(num);
        }
        for (int key : map.keySet()) {
            List<Integer> thisNumList = map.get(key);
            if (thisNumList.size() < 2) {
                continue;
            }
            Collections.sort(thisNumList);
            result = Math.max(thisNumList.get(thisNumList.size() - 1) + thisNumList.get(thisNumList.size() - 2), result);
        }
        return result;
    }
    
    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }
}