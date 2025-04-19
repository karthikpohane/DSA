class Solution {
    private String getFrequenceString(String str){
        int[] freq = new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder frequenceString = new StringBuilder("");
        char c = 'a';
        for(int i: freq){
            frequenceString.append(c);
            frequenceString.append(i);
            c++;
        }

        return frequenceString.toString();

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> frequenceStringMap = new HashMap<>();
        for(String str: strs){
            String frequenceString = getFrequenceString(str);

            if(frequenceStringMap.containsKey(frequenceString)) {
                frequenceStringMap.get(frequenceString).add(str);
            }
            else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequenceStringMap.put(frequenceString, strList);
            }
        }
        return new ArrayList<>(frequenceStringMap.values());
    }
}