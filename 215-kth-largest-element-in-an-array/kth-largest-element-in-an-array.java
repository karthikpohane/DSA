class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queueKi = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            queueKi.add(nums[i]);
        }
        for(int i=k; i<nums.length; i++){
            if(queueKi.peek() < nums[i]){
                queueKi.poll();
                queueKi.add(nums[i]);
            }
        }
        return queueKi.peek();
    }
}