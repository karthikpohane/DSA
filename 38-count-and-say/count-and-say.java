class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    current.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            current.append(count).append(result.charAt(result.length() - 1));
            result = current.toString();
        }

        return result;
    }
}
