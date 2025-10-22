// Last updated: 10/22/2025, 12:39:20 AM
class Solution {
    public String minimumString(String a, String b, String c) {
        String result = a + b + c;
        String subResult1 = concatString(concatString(a, b), c);
        if (compareLexicographically(subResult1, result) < 0) {
            result = subResult1;
        }
        String subResult2 = concatString(concatString(a, c), b);
        if (compareLexicographically(subResult2, result) < 0) {
            result = subResult2;
        }
        String subResult3 = concatString(concatString(b, c), a);
        if (compareLexicographically(subResult3, result) < 0) {
            result = subResult3;
        }
        String subResult4 = concatString(concatString(b, a), c);
        if (compareLexicographically(subResult4, result) < 0) {
            result = subResult4;
        }
        String subResult5 = concatString(concatString(c, a), b);
        if (compareLexicographically(subResult5, result) < 0) {
            result = subResult5;
        }
        String subResult6 = concatString(concatString(c, b), a);
        if (compareLexicographically(subResult6, result) < 0) {
            result = subResult6;
        }
        return result;
        
    }
    
    private int compareLexicographically(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return str1.length() - str2.length();
        }
        return str1.compareTo(str2);
    }
    
    public String concatString(String str1, String str2) {
        if (str2.contains(str1)) {
            return str2;
        } else if (str1.contains(str2)) {
            return str1;
        }
        for (int len = Math.min(str1.length(), str2.length()); len > 0; len--) {
            String subStr = str2.substring(0, len);
            if (str1.substring(str1.length() - len, str1.length()).equals(subStr)) {
                return str1 + str2.substring(len);
            }
        }
        return str1 + str2;
    }
}