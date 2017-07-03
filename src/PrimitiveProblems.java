/**
 * Created by lwassink on 7/1/17.
 */
public class PrimitiveProblems {
    public static long pow(long x, int y) {
        return (y < 0) ? 1 / posPow(x, -y) : posPow(x, y);
    }

    private static long posPow(long x, int y) {
        if (y == 0) return 1;
        if (y == 1) return x;

        int halfY = y >>> 1;
        long sqrt = posPow(x, halfY);
        return sqrt * sqrt * posPow(x, y - (halfY << 1));
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 0));
        System.out.println(Math.pow(2, 0));
        System.out.println(pow(2, 1));
        System.out.println(Math.pow(2, 1));
        System.out.println(pow(2, 2));
        System.out.println(Math.pow(2, 2));
        System.out.println(pow(2, 3));
        System.out.println(Math.pow(2, 3));

        System.out.println(pow(5, 1));
        System.out.println(Math.pow(5, 1));
        System.out.println(pow(5, 2));
        System.out.println(Math.pow(5, 2));
        System.out.println(pow(5, 3));
        System.out.println(Math.pow(5, 3));
    }
}
