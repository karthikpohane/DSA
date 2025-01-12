class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2!=0) return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        
        for(int i=0; i<n; i++)
        {
            //Step: 1
            if(locked.charAt(i)=='0')
                openClose.push(i);
            //Step: 2
            else if(s.charAt(i)=='(')
                open.push(i);
            else if(s.charAt(i)==')'){
                if(!open.empty()) open.pop();
                else if(!openClose.empty()) openClose.pop();
                else return false;
            }
        }
        //Step: 3
        while(!open.empty() && !openClose.empty() && open.peek() < openClose.peek())
        {
            open.pop();
            openClose.pop();
        }
       return open.empty();
    }
}