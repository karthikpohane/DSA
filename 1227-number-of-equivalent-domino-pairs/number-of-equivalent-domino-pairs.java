class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] arr = new int[100];
        int result = 0;
        
        for (int[] val : dominoes) {
            int a = val[0];
            int b = val[1];
            int nums = a > b ? b * 10 + a : a * 10 + b;
            result += arr[nums];
            arr[nums]++;
        }
        
        return result;
    }
}
