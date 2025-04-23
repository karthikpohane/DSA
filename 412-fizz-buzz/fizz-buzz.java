class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        int fizzCount = 0;
		int buzzCount = 0;
        for(int i = 1; i<=n; i++){
		fizzCount++;
		buzzCount++;
		
		boolean fizz = fizzCount == 3;
		boolean buzz = buzzCount == 5;

		if(fizz && buzz) {
		result.add("FizzBuzz");
		fizzCount = 0;
		buzzCount = 0;
		} else if(fizz) {
		result.add("Fizz");
		fizzCount = 0;
		} else if(buzz) {
		result.add("Buzz");
		buzzCount = 0;
		} else {
		result.add(Integer.toString(i));
		}
    }

        return result;
    }
}