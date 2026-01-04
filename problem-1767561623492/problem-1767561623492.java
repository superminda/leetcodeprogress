// Last updated: 1/4/2026, 4:20:23 PM
1class Solution {
2    public List<List<String>> wordSquares(String[] words) {
3        List<List<String>> result = new ArrayList<>();
4        Map<String, List<String>> map = new HashMap<>();
5        Map<Character, List<String>> initialMap = new HashMap<>();
6        for (String word : words) {
7            String key = word.charAt(0) + "" + word.charAt(3);
8            if (map.containsKey(key)) {
9                map.get(key).add(word);
10            } else {
11                List<String> value = new ArrayList<>();
12                value.add(word);
13                map.put(key, value);
14            }
15            char firstChar = word.charAt(0);
16            if (initialMap.containsKey(firstChar)) {
17                initialMap.get(firstChar).add(word);
18            } else {
19                List<String> value = new ArrayList<>();
20                value.add(word);
21                initialMap.put(word.charAt(0), value);
22            }
23        }
24        for (String top : words) {
25            if (!initialMap.containsKey(top.charAt(0)) || !initialMap.containsKey(top.charAt(3))) {
26                continue;
27            }
28            if (top.charAt(0) == top.charAt(3)) {
29                if (initialMap.get(top.charAt(0)).size() <= 2) {
30                    continue;
31                }
32            } else {
33                 if (initialMap.get(top.charAt(0)).size() == 1) {
34                    continue;
35                }
36            }
37
38            for (String left : initialMap.get(top.charAt(0))) {
39                if (left.equals(top)) {
40                    continue;
41                }
42
43                if (!initialMap.containsKey(left.charAt(3))) {
44                    continue;
45                }
46                for (String bottom : initialMap.get(left.charAt(3))) {
47                    if (left.equals(bottom) || top.equals(bottom)) {
48                        continue;
49                    }
50                    String rightKey = top.charAt(3) + "" + bottom.charAt(3);
51                    if (!map.containsKey(rightKey)) {
52                        continue;
53                    }
54                    for (String right : map.get(rightKey)) {
55                        if (left.equals(right) || top.equals(right) || bottom.equals(right)) {
56                            continue;
57                        }
58                        List<String> subResult = new ArrayList<>();
59                        subResult.add(top);
60                        subResult.add(left);
61                        subResult.add(right);
62                        subResult.add(bottom);
63                        result.add(subResult);
64                    }
65                }
66            }
67        }
68        Collections.sort(result, (a, b) -> (a.get(0) + a.get(1) + a.get(2) + a.get(3)).compareTo(b.get(0) + b.get(1) + b.get(2) + b.get(3)));
69        return result;
70    }
71}