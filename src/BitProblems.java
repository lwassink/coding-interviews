/**
 * Created by lwassink on 6/9/17.
 */
public class BitProblems {
    public static short parity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        return (short) (1 & (x ^ (x >>> 1)));
    }

    private static long rightMost(long x) {
        return x & ~(x - 1);
    }

    public static long rightProp(long x) {
        return x | (rightMost(x) - 1);
    }

    public static long modulo(long x, int power) {
        return x & ((1 << power) - 1);
    }

    public static Boolean isPowerOfTwo(long x) {
        return (x ^ rightMost(x)) == 0;
    }

    public static void main(String[] args) {
        System.out.println("Bits!");
        System.out.println(parity(0));
        System.out.println(parity(1));
        System.out.println(parity(2));
        System.out.println(parity(3));
        System.out.println(parity(4));
        System.out.println(parity(5));

        System.out.println(rightProp(8));

        System.out.println(modulo(7, 2));

        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(7));
    }
}
