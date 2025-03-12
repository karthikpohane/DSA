class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> oddArray = new ArrayList<>();
        ArrayList<Integer> evenArray = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i%2==0) evenArray.add(nums[i]);
            else oddArray.add(nums[i]);
        }

        Collections.sort(evenArray);
        Collections.sort(oddArray, Collections.reverseOrder());

        int evenIndex = 0;
        int oddIndex = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                nums[i] = evenArray.get(evenIndex++);
            } else nums[i] = oddArray.get(oddIndex++);
        }
        return nums;
    }
}