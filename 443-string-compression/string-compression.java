class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int index = 0;
        while(i < n){
            char curr_char = chars[i];
            int count = 0;
            while(i < n && chars[i] == curr_char) {
                count++;
                i++;
            }
            
            chars[index] = curr_char;
            index++;
            if(count > 1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[index] = c;
                    index++;
                }
            }
        }
        return index;
    }
}