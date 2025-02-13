class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<Character>();
        StringBuffer temp = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty())
                st.pop();
            }
        }
        while(!st.isEmpty()) {
            temp.append(st.pop());
        }
        return temp.reverse().toString();

    }
}