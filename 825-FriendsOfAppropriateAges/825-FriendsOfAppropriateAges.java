// Last updated: 11/29/2025, 12:11:22 AM
1class Solution {
2    public int numFriendRequests(int[] ages) {
3        int result = 0;
4        Arrays.sort(ages);
5        List<Integer> distinctAges = new ArrayList<>();
6        int[] ageCount = new int[121];
7        for (int index = 0; index < ages.length; index++) {
8            if (index == 0 || ages[index - 1] != ages[index]) {
9                distinctAges.add(ages[index]);
10            }
11            int age = ages[index];
12            ageCount[age]++;
13        }
14        int[] prevAgeCount = new int[121];
15        for (int age = 1; age <= 120; age++) {
16            prevAgeCount[age] = prevAgeCount[age - 1] + ageCount[age];
17        }
18        int prevIndex = 0;
19        for (int thisIndex = 0; thisIndex < distinctAges.size(); thisIndex++) {
20            int thisAge = distinctAges.get(thisIndex);
21            int minFriendAge = Math.min(thisAge, (int)Math.floor((thisAge * 0.5)) + 7);
22            if (minFriendAge != thisAge) {
23                result += ageCount[thisAge] * (prevAgeCount[thisAge] - prevAgeCount[minFriendAge] - 1);
24            }
25        }
26        return result;
27    }
28}