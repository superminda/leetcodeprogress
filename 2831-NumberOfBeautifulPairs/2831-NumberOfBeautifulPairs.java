// Last updated: 10/22/2025, 12:39:31 AM
class Solution {
    private Map<String, Boolean> isCoprimeMap;
    public int countBeautifulPairs(int[] nums) {
        this.isCoprimeMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int firstDigit = getFirstDigit(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int lastDigit = getLastDigit(nums[j]);
                String key = Math.min(firstDigit, lastDigit) + "-" + Math.max(firstDigit, lastDigit);
                if (isCoprime(key, firstDigit, lastDigit)) {
                    result++;
                }
            }
        }
        return result;
    }
    
    private boolean isCoprime(String key, int num1, int num2) {
        if (this.isCoprimeMap.containsKey(key)) {
            return this.isCoprimeMap.get(key);
        }
        boolean isCoprime = true;
        for (int i = 2; i <= Math.min(num1, num2); i++) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                isCoprime = false;
                break;
            }
        }
        this.isCoprimeMap.put(key, isCoprime);
        return isCoprime;
    }
    
    private int getFirstDigit(int num) {
        String str = String.valueOf(num);
        return str.charAt(0) - '0';
    }
    
    private int getLastDigit(int num) {
        String str = String.valueOf(num);
        return str.charAt(str.length() - 1) - '0';
    }
}