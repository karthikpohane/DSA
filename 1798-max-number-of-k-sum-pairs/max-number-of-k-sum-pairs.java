class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int count = 0;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum == k){
                count++;
                low++;
                high--;
            }
            else if(sum<k)
                low++;
            else high--;
        }
        return count;
    }
}