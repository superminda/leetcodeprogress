// Last updated: 10/22/2025, 12:41:06 AM
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, Set<Integer>> uams = new HashMap<>();
        
        for (int[] log : logs) {
            int currentUser = log[0];
            int currentTime = log[1];
            Set<Integer> currentTimeSet = uams.containsKey(currentUser) ? uams.get(currentUser) : new HashSet<>(); 
            currentTimeSet.add(currentTime);
            uams.put(currentUser, currentTimeSet);
        }
        
        for (Integer i : uams.keySet()) {
            result[uams.get(i).size() - 1] += 1;
        }
        
        return result;
    }
}