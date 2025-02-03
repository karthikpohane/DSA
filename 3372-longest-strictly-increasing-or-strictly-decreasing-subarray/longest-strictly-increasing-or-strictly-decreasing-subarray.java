class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxInc = 1;
        int maxDec = 1;
        int inc = 1;
        int dec = 1;
        for(int i=0; i<n-1; i++){
            if(nums[i]<nums[i+1]){
            inc++;
            maxInc = Math.max(maxInc, inc);
            dec=1;
            }else if(nums[i]>nums[i+1]){
            dec++;
            maxDec = Math.max(maxDec, dec);
            inc=1;
            }else{
                inc=1;
                dec=1;
            }

        }
        int result = Math.max(maxInc, maxDec);
        return result;
    }
}