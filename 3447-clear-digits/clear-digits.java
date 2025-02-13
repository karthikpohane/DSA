class Solution {
    public String clearDigits(String s) {
        StringBuffer temp = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                temp.append(s.charAt(i));
            }else if(temp.length()>0){
                temp.deleteCharAt(temp.length()-1);
            }
        }
        return temp.toString();

    }
}