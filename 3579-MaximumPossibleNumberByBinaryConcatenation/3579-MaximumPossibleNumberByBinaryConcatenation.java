// Last updated: 10/22/2025, 12:39:12 AM
class Solution {
    int maxNumber;
    public int maxGoodNumber(int[] nums) {
        this.maxNumber = 0;
        List<String> binaryStrList = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            binaryStrList.add(Integer.toBinaryString(nums[index]));
        }
        boolean[] visited = new boolean[3];
        search(binaryStrList, visited, "");
        
        return maxNumber;
    }
    
    private void search(List<String> binaryStrList, boolean[] visited, String currentStr) {
        if (visited[0] && visited[1] && visited[2]) {
            maxNumber = Math.max(maxNumber, Integer.parseInt(currentStr, 2));
            return;
        }
        for (int index = 0; index < visited.length; index++) {
            if (visited[index]) {
                continue;
            }
            visited[index] = true;
            search(binaryStrList, visited, currentStr + binaryStrList.get(index));
            visited[index] = false;
        }
    }
}