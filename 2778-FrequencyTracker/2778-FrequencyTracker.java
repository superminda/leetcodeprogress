// Last updated: 10/22/2025, 12:40:20 AM
class FrequencyTracker {

    private Map<Integer, Set<Integer>> frequencyMap;
    private Map<Integer, Integer> countMap;
    public FrequencyTracker() {
        this.frequencyMap = new HashMap<>();
        this.countMap = new HashMap<>();
    }
    
    public void add(int number) {
        int currFreq = countMap.getOrDefault(number, 0);
        if (currFreq != 0) {
            frequencyMap.get(currFreq).remove(number);
        }
        if (!frequencyMap.containsKey(currFreq + 1)) {
            frequencyMap.put(currFreq + 1, new HashSet<>());
        }
        frequencyMap.get(currFreq + 1).add(number);
        countMap.put(number, currFreq + 1);
    }
    
    public void deleteOne(int number) {
        int currFreq = countMap.getOrDefault(number, 0);
        if (currFreq == 0) {
            return;
        }
        frequencyMap.get(currFreq).remove(number);
        if (currFreq == 1) {
            countMap.remove(number);
            return;
        }
        countMap.put(number, currFreq - 1);
        if (!frequencyMap.containsKey(currFreq - 1)) {
            frequencyMap.put(currFreq - 1, new HashSet<>());
        }
        frequencyMap.get(currFreq - 1).add(number);
    }
    
    public boolean hasFrequency(int frequency) {
        return frequencyMap.containsKey(frequency) && !frequencyMap.get(frequency).isEmpty();
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */