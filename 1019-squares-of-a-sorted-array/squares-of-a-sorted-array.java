class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int idx = right;
        while(left<=right){
            int lsq = nums[left] * nums[left];
            int rsq = nums[right] * nums[right];

            if(lsq > rsq){
                result[idx] = lsq;
                left++;
            } else {
                result[idx] = rsq;
                right--;
            }
            idx--;
        }
        return result;
    }
}