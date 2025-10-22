// Last updated: 10/22/2025, 12:41:00 AM
class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int temp = 0;
            while (num > 0) {
                temp *= 10;
                temp += num % 10;
                num /= 10;
            }
            set.add(temp);
        }
        return set.size();
    }
}