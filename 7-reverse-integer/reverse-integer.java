class Solution {
    public int reverse(int x) {
        int memo = 0;
        boolean flag = false;
        if(x<0) {
            x = -1*x;
            flag = true;
        }
            
        while(x>0){
            if (memo > (Integer.MAX_VALUE / 10) || 
                (memo == Integer.MAX_VALUE / 10 && (x%10) > 7)) {
                return 0;
            }
            memo = memo *10 + (x%10);
            x = x/10;
        }
        return flag ? -1*memo : memo;
    }
}