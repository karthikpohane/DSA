class Solution {
    public int longestOnes(int[] nums, int k) {
      //Aquire and release Approach (Kind of sliding window).
      //Using two pointers to aquire and release.
      //Size of the valid string will be i-1-j
      //Initially the values of i=0 and j=-1
      //when encounter zero increase the value of count which should be less or equal to k.
      //when the count becomes greater than k then the window becomes invalid and to make it valid you will need to release. 
      //release will be by increaseing the value to j.

      int i = 0;
      int j = -1;
      int ans = 0;
      int coziw = 0;  //Count of zeros in window.
      while(i != nums.length){
        //Aquire 
        if(nums[i] == 0){
            coziw++;
            i++;
        } else {
            i++;
        }
        //if invalid release till valid again.
        while(coziw > k){
            j++;
            if(nums[j] == 0){
                coziw--;
            } 
        }
        int sow = i-1-j;
        ans = Math.max(ans, sow);
      }
      return ans;
    }
}