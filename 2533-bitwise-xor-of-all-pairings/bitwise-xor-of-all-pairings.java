class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
       int n = nums1.length;
       int m = nums2.length; 
       int result = 0;

       if(n%2!=0)
       {
        for(int num: nums2)
        {
            result ^= num;
        }
       }
       if(m%2!=0)
       {
        for(int num: nums1)
        {
            result ^= num;
        }
       }
       return result;
    }
}