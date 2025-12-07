// Last updated: 12/6/2025, 11:08:39 PM
1class Solution {
2    public int[] sortByReflection(int[] nums) {
3        List<Pair<Integer, Integer>> list = new ArrayList<>();
4        for (int num : nums) {
5            int binaryReflectionNum = getBinaryReflection(num);
6            list.add(new Pair(num, binaryReflectionNum));
7        }
8        Collections.sort(list, (a, b) -> (a.getValue() - b.getValue() != 0 ? Integer.compare(a.getValue(), b.getValue()) : Integer.compare(a.getKey(), b.getKey())));
9        int[] result = new int[nums.length];
10        for (int i = 0; i < result.length; i++) {
11            result[i] = list.get(i).getKey();
12        }
13        return result;
14    }
15
16    private int getBinaryReflection(int num) {
17        int result = 0;
18        while (num > 0) {
19            result = 2 * result + num % 2;
20            num /= 2;
21        }
22        return result;
23    }
24}