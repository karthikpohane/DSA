class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int maxLen = 0;
        int jumps = 0;
        int current = 0;
       for(int i=0; i<nums.length; i++){
        int len = i + nums[i];
        maxLen = Math.max(maxLen, len);
        if(i==current){
            jumps++;
            current = maxLen;
        }
        if(current >= nums.length-1) return jumps;
       }
       return jumps; 
    }
}