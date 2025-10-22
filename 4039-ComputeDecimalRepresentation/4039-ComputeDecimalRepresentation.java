// Last updated: 10/22/2025, 12:39:05 AM
class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> list = new ArrayList<>();
        int power = 1;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit != 0) {
                list.add(lastDigit * power);
            }
            n /= 10;
            power *= 10;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }
        return result;
    }
}