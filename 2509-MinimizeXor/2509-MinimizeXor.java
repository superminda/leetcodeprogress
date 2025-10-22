// Last updated: 10/22/2025, 12:41:02 AM
class Solution {
    public int minimizeXor(int num1, int num2) {
        int numberOfOnes = 0;
        while (num2 > 0) {
            if (num2 % 2 == 1) {
                numberOfOnes++;
            }
            num2 /= 2;
        }
        
        int[] binary1 = new int[32];
        boolean[] visited = new boolean[32];
        int index = 31;
        int num1Copy = num1;
        while (num1Copy > 0) {
            binary1[index--] = num1Copy % 2;
            num1Copy /= 2;
        }
        
        for (int i = 0; i < 32; i++) {
            if (binary1[i] == 1) {
                if (numberOfOnes == 0) {
                    break;
                }
                numberOfOnes--;
                binary1[i] = 0;
                visited[i] = true;
            }
        }
        
        for (int i = 31; i >= 0; i--) {
            if (!visited[i]) {
                if (numberOfOnes == 0) {
                    break;
                }
                numberOfOnes--;
                binary1[i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = 2 * result + binary1[i];
        }
        return result ^ num1;
    }
}