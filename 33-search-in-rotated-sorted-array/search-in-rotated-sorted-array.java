class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            //Sorting property: (nums[low] <= nums[mid])
            //Check for left sorted
            if(nums[low]<=nums[mid]){
                //Now check if the target exists in left sorted array.
                if(nums[low]<=target && target<=nums[mid])
                    high = mid-1;
                else 
                    low = mid+1;
            } 
            //else right array is sorted.
            else{
                //Check the target in right sorted array.
                if(nums[mid]<=target && target <= nums[high])
                    low = mid+1;
                else 
                    high = mid-1;
            }
        }
        return -1;
    }
}