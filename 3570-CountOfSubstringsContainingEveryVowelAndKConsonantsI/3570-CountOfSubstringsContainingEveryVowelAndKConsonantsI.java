// Last updated: 10/22/2025, 12:39:13 AM
class Solution {
    public int countOfSubstrings(String word, int k) {
        int result = 0;
        
        int n = word.length();
        Counter[] arrays = new Counter[n + 1];
        arrays[0] = new Counter();
        
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;
        int consonantCount = 0;
        
        for (int i = 0; i < n; i++) {
            char thisChar = word.charAt(i);
            if (thisChar == 'a') {
                aCount++;
            } else if (thisChar == 'e') {
                eCount++;
            } else if (thisChar == 'i') {
                iCount++;
            } else if (thisChar == 'o') {
                oCount++;
            } else if (thisChar == 'u') {
                uCount++;
            } else {
                consonantCount++;
            }
            arrays[i + 1] = new Counter(aCount, eCount, iCount, oCount, uCount, consonantCount);
        }
        
        for (int start = 0; start < n; start++) {
            Counter startCounter = arrays[start];
            for (int end = start - 1 + 5 + k; end < n; end++) {
                Counter endCounter = arrays[end + 1];
                if (endCounter.consonantCount - startCounter.consonantCount > k) {
                    break;
                } else if (endCounter.consonantCount - startCounter.consonantCount == k) {
                    if ((endCounter.aCount - startCounter.aCount >= 1)
                        && (endCounter.eCount - startCounter.eCount >= 1) 
                        && (endCounter.iCount - startCounter.iCount >= 1) 
                        && (endCounter.oCount - startCounter.oCount >= 1)
                        && (endCounter.uCount - startCounter.uCount >= 1)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

class Counter {
    public int aCount;
    public int eCount;
    public int iCount;
    public int oCount;
    public int uCount;
    public int consonantCount;
    public Counter() {
        this.aCount = 0;
        this.eCount = 0;
        this.iCount = 0;
        this.oCount = 0;
        this.uCount = 0;
        this.consonantCount = 0;
    }
    public Counter(int aCount, int eCount, int iCount, int oCount, int uCount, int consonantCount) {
        this.aCount = aCount;
        this.eCount = eCount;
        this.iCount = iCount;
        this.oCount = oCount;
        this.uCount = uCount;
        this.consonantCount = consonantCount;
    }
}