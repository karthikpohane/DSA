class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        // Prefix pass
        int operations = 0, count = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                count++;
            }
            operations += count;
        }
        
        // Suffix pass
        operations = 0;
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                count++;
            }
            operations += count;
        }
        
        return answer;
    }
}
