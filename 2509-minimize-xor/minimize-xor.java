class Solution {
    private boolean isSet(int x, int bit)
    {
        return (x & (1<<bit)) != 0;
    }
    private int setBit(int x, int bit)
    {
        return x | (1<<bit);
    }
    public int minimizeXor(int num1, int num2) {
        int x = 0;
        int requiredBitCount = Integer.bitCount(num2);

        for(int bit = 31; bit>=0 && requiredBitCount > 0; bit--)
        {
            if(isSet(num1, bit))
            {
                x = setBit(x, bit);
                requiredBitCount --;
            }
        }

        for(int bit = 0; bit<32 && requiredBitCount > 0; bit++)
        {
            if(!isSet(x,bit))
            {
                x = setBit(x,bit);
                requiredBitCount--;
            }
        }
        return x;
    }
}