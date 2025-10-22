// Last updated: 10/22/2025, 12:41:08 AM
class Solution {
    public String truncateSentence(String s, int k) {
        String[] truncatedStrings = s.split(" ", k + 1);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < k; i++) {
            if (i > truncatedStrings.length - 1) {
                break;
            }
            sb.append(truncatedStrings[i]);
            sb.append(' ');
        }
        
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}