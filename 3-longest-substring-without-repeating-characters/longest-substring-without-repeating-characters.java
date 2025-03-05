class Solution {
    public int lengthOfLongestSubstring(String s) {
        //if(s.length()==1) return 1;
        int[] arry = new int[255];
        for(int i=0; i<arry.length; i++){
            arry[i] = -1;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right<s.length()){
            if(arry[s.charAt(right)] != -1){
                if(arry[s.charAt(right)]>=left){
                    left = arry[s.charAt(right)] + 1;
                }
            }
            int len = right-left+1;
            maxLen = Math.max(len, maxLen);
            arry[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}