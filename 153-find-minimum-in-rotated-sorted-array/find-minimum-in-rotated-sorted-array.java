class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high  = n-1;
        int min = Integer.MAX_VALUE; //Use MAX value because using min will always have the same value.
        while(low<=high){
            int mid = (low+high)/2;
            //Check for the sorted array and make the low as min
            if(nums[low]<=nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid+1;
            } else{
                high = mid-1;
                min = Math.min(min, nums[mid]);
            }
        }
        return min;
    }
}