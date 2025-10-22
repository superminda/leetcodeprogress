// Last updated: 10/22/2025, 12:40:39 AM
class Solution {
    public long beautifulSubarrays(int[] nums) {
        long result = 0l;
        Map<String, Integer> map = new HashMap<>();
        int[] counts = new int[20];
        map.put("ffffffffffffffffffff", 1);
        for (int num : nums) {
            String binaryStr = Integer.toBinaryString(num);
            for (int i = 0; i < 20 && i < binaryStr.length(); i++) {
                if (binaryStr.charAt(binaryStr.length() - 1 - i) == '1') {
                    counts[i]++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                sb.append((counts[i] % 2 == 0) ? 'f' : 't');
            }
            String key = sb.toString();
            int currCount = map.getOrDefault(key, 0);
            result += currCount;
            map.put(key, currCount + 1);
        }
        
        return result;
    }
}