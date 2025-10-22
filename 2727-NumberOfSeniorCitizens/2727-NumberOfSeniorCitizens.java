// Last updated: 10/22/2025, 12:40:27 AM
class Solution {
    public int countSeniors(String[] details) {
        return (int)Arrays.stream(details).filter(d -> Integer.valueOf(d.substring(11, 13)) > 60).count();
    }
}