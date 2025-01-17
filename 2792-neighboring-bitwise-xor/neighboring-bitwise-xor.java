class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        if (n == 1) {
            return derived[0] == 0;
        }

        for (int j = 0; j < 2; j++) {
            int[] org = new int[n];
            org[0] = j; 
           
            for (int i = 1; i < n; i++) {
                org[i] = org[i - 1] ^ derived[i - 1];
            }

            
            if ((org[n - 1] ^ org[0]) == derived[n - 1]) {
                return true;
            }
        }

        return false; 
    }
}
