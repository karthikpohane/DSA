class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] org = new int[n];

        if (n == 1) {
            return derived[0] == 0;
        }
        org[0] = 0; 
           
            for (int i = 1; i < n; i++) {
                org[i] = org[i - 1] ^ derived[i - 1];
            }

            
            if ((org[n - 1] ^ org[0]) == derived[n - 1]) {
                return true;
            }
        
        org[0] = 1; 
           
            for (int i = 1; i < n; i++) {
                org[i] = org[i - 1] ^ derived[i - 1];
            }

            
            if ((org[n - 1] ^ org[0]) == derived[n - 1]) {
                return true;
            }

        return false; 
    }
}
