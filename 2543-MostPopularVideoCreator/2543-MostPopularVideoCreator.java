// Last updated: 10/22/2025, 12:40:56 AM
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        long maxCount = 0;
        Map<String, Long> counter = new HashMap<>();
        for (int index = 0; index < creators.length; index++) {
            String creator = creators[index];
            int view = views[index];
            long totalView = counter.getOrDefault(creator, 0l) + view;
            maxCount = Math.max(maxCount, totalView);
            counter.put(creator, totalView);
        }
        Set<String> qualifiedCreatorSet = new HashSet<>();
        for (String creator : counter.keySet()) {
            if (counter.get(creator) == maxCount) {
                qualifiedCreatorSet.add(creator);
            }
        }
        Map<String, Pair<String, Integer>> maxViewMap = new HashMap<>();
        
        for (int index = 0; index < creators.length; index++) {
            String creator = creators[index];
            if (!qualifiedCreatorSet.contains(creator)) {
                continue;
            }
            String id = ids[index];
            int view = views[index];
            if (!maxViewMap.containsKey(creator)) {
                maxViewMap.put(creator, new Pair<String, Integer>(id, view));
            } else {
                Pair<String, Integer> existingPair = maxViewMap.get(creator);
                if (existingPair.getValue() < view || (existingPair.getValue() == view && existingPair.getKey().compareTo(id) > 0)) {
                    maxViewMap.put(creator, new Pair<String, Integer>(id, view));
                }
            }
        }
        for (String creator : maxViewMap.keySet()) {
            Pair<String, Integer> existingPair = maxViewMap.get(creator);
            result.add(Arrays.asList(creator, existingPair.getKey()));
        }
        return result;
    }
}