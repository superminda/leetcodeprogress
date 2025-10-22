// Last updated: 10/22/2025, 12:41:04 AM
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<PersonalInfo> list = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            list.add(new PersonalInfo(heights[index], names[index]));
        }
        Collections.sort(list, (a, b) -> (b.height - a.height));
        
        String[] result = new String[n];
        for (int index = 0; index < n; index++) {
            result[index] = list.get(index).name;
        }
        return result;
    }
}

class PersonalInfo {
    public final int height;
    public final String name;
    public PersonalInfo(int height, String name) {
        this.height = height;
        this.name = name;
    }
}