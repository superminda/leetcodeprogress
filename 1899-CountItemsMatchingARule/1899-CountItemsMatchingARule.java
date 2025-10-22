// Last updated: 10/22/2025, 12:41:09 AM
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int keyInt = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int result = 0;
        
        for (List<String> item : items) {
            if (item.get(keyInt).equals(ruleValue)) {
                result += 1;
            } 
        }
        
        return result;
        
    }
}