class Solution {
    public int numRabbits(int[] answers) {
         //Identify the groups size and how many groups are there.
         //1. Ceration of frequence map
         HashMap<Integer, Integer> frequenceMap = new HashMap<>();
         for(int val: answers){
            frequenceMap.put(val, frequenceMap.getOrDefault(val, 0)+1);
         }

         //2. loop through the map to get the group size and total groups required.
         int ans = 0;
         for(int key: frequenceMap.keySet()){
            int grpSize = key+1;
            int reportees = frequenceMap.get(key);
            int totalGroups = (int)Math.ceil((double)reportees / (double)grpSize);
            ans += totalGroups * grpSize;
         }
         return ans;
    }
}