// Last updated: 10/22/2025, 12:40:25 AM
class Solution {
    public int addMinimum(String word) {
        int result = 0;
        int aCount = 0;
        int bCount = 0;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char thisChar = word.charAt(i);
            if (thisChar == 'a') {
                if (bCount == aCount) {
                    if (bCount == 1) {
                        result += 1; // add c
                        aCount = 1;
                        bCount = 0;
                    } else {
                        // bCount == 0;
                        aCount++;
                    }
                } else {
                    // bCount = 0;
                    result += 2; // add b then c
                    aCount = 1;
                }
            } else if (thisChar == 'b') {
                if (bCount == aCount) {
                    if (aCount == 0) {
                        result++; // add a
                        aCount = 1;
                        bCount = 1;
                    } else {
                        // bCount == 1;
                        result += 2; // add c, then a
                        aCount = 1;
                        bCount = 1;
                    }
                } else {
                    bCount = 1;
                }
            } else {
                if (aCount == bCount) {
                    if (aCount == 0) {
                        result += 2; // add a, then b
                    } else {
                        aCount = 0;
                        bCount = 0;
                    }
                } else {
                    result++; // add b
                    aCount = 0;
                    bCount = 0;
                }
            }
        }
        if (aCount != 0) {
            if (bCount != 0) {
                result++; // add c;
            } else {
                result += 2; // add b, c
            }
        }
        return result;
    }
}