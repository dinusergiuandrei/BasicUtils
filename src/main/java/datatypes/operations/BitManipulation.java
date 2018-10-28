package datatypes.operations;

/**
 * Bit at index 0 is least relevant.
 * Penultimate bit is most relevant.
 * Last bit gives the sign. (1 -> positive or zero, 0 -> negative)
 */
public class BitManipulation {
    public static int computeIntegerFromBits(boolean[] bits) {
        int result = 0, p = 1;
        for (int index = 0; index < bits.length - 1; index++) {
            result += getIntFromBit(bits[index]) * p;
            p *= 2;
        }
        return result * computeSignForInteger(bits);
    }

    public static boolean[] computeBitsFromIntegerOnFixedLength(int x, int length) {
        int minLength = computeBitLength(x);
        if (minLength > length)
            throw new NumberFormatException("Given bit length " + length + " is not enough to contain the bits of " + x);

        boolean[] bits = new boolean[length];

        bits[bits.length - 1] = computeSignForBits(x);
        if (x < 0)
            x *= -1;
        int index = 0;
        while (x > 0) {
            bits[index++] = getBitFromInt(x % 2);
            x /= 2;
        }
        while (index < bits.length - 1) {
            bits[index++] = false;
        }
        return bits;
    }

    public static int computeBitLength(int x) {
        short length = 0;
        if (x < 0) {
            x *= -1;
        }
        while (x > 0) {
            ++length;
            x /= 2;
        }
        return length + 1; // +1 for the sign
    }

    static boolean computeSignForBits(int x) {
        return x >= 0;
    }

    static int computeSignForInteger(boolean bits[]) {
        if (bits[bits.length - 1])
            return 1;
        else return -1;
    }

    public static int computeMaxValueOnBitsCount(int bitsLength) {
        return (1 << (bitsLength - 1)) - 1;
    }

    public static boolean[] extractNBitsStartingFrom(boolean[] bits, int startingPoint, int count) {
        boolean[] result = new boolean[count];
        System.arraycopy(bits, startingPoint, result, 0, count);
        return result;
    }

    public static int getIntFromBit(boolean bit){
        if (bit)
            return 1;
        return 0;
    }

    public static boolean getBitFromInt(int x){
        if(x == 0)
            return false;
        return true;
    }
}
