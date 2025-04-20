class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> numsSet = new HashSet<>();
       for(int val: nums){
        numsSet.add(val);
       }
       int longLen = 0;
       for(int val: numsSet){
        if(!numsSet.contains(val-1)){
            int length = 0;
            while(numsSet.contains(val+length)){
                length += 1;
            }
            longLen = Math.max(longLen, length);
        }
       }
       return longLen;
    }
}