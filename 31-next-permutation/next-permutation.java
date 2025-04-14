class Solution {
    public void nextPermutation(int[] nums) {
    //Step 1 - finding the bearking point 
    int n = nums.length;
    int ind = -1;
    for(int i=n-2; i>=0; i--){
        if(nums[i]<nums[i+1]){
            ind = i;
            break;
        }
    }
    if(ind == -1){
            reverse(nums, 0, n - 1);
            return;
        }
    //Step 2 - now finding the closest of the breaking point ele
    for(int i = n-1; i>ind; i--){
        //Swap logic
        if(nums[i]>nums[ind]){
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
            break;
        }
    }
    //Step 3 - Reverse and ans
    reverse(nums, ind+1, n-1);
    }

    //reverse logic
    private void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}