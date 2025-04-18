class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();      // convert to char array
            Arrays.sort(chars);                    // sort the characters
            String sorted = new String(chars);     // convert back to string

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        result.addAll(map.values());               // collect all anagram groups
        return result;
    }
}
