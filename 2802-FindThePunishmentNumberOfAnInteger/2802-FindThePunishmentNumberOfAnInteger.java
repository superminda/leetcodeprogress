// Last updated: 10/22/2025, 12:40:14 AM
class Solution {
    public int punishmentNumber(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            int square = i * i;
            if (isQualified(i)) {
                result += i * i;
            }
        }
        return result;
    }
    
    private boolean isQualified(int num) {
        int square = num * num;
        char[] charArray = String.valueOf(square).toCharArray();
        return search(0, num, charArray);
    }
    
    private boolean search(int index, int target, char[] charArray) {
        if (index == charArray.length) {
            return target == 0;
        }
        int thisNum = 0;
        for (int i = index; i < charArray.length; i++) {
            thisNum *= 10;
            thisNum += (charArray[i] - '0');
            if (thisNum > target) {
                return false;
            }
            if (search(i + 1, target - thisNum, charArray)) {
                return true;
            }
        }
        return false;
    }
}