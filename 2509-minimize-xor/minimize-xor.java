class Solution {
    protected boolean isSet(int x, int bit){
        return (x & (1<<bit)) != 0;
    }

    private int setBit(int x, int bit){
        return x | (1<<bit);
    }

    private int unSetBit(int x, int bit){
        return x & ~(1<<bit);
    }

    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int requiredSetBits = Integer.bitCount(num2);
        int currentSetBit = Integer.bitCount(x);

        int bit = 0;
        if(currentSetBit < requiredSetBits){
            while(currentSetBit < requiredSetBits)
            {
                if(!isSet(x,bit)){
                    x = setBit(x, bit);
                    currentSetBit++;
                }
                bit++;
            }
        } else if(currentSetBit > requiredSetBits){
            while(currentSetBit > requiredSetBits){
                if(isSet(x,bit)){
                    x = unSetBit(x, bit);
                    currentSetBit--;
                }
                bit++;
            }
        }
        return x;
    }
}