/**
 * Created by lwassink on 6/9/17.
 */
public class StringProblems {
    public static int toInt(String str) {
        int idx = 0, result = 0;
        Boolean neg = (str.charAt(0) == '-');
        if (neg) idx++;

        while (idx < str.length()) {
            result = (10 * result) + (str.charAt(idx++) - '0');
        }

        if (neg) result = -result;
        return result;
    }

    public static String fromInt(int x) {
        if (x == 0) return "0";

        StringBuilder sb = new StringBuilder();
        Boolean neg = false;
        if (x < 0) {
            x = -x;
            neg = true;
        }

        while (x > 0) {
            sb.append(x % 10);
            x = x / 10;
        }

        if (neg) sb.append('-');

        return sb.reverse().toString();
    }

    private static int toInt(String str, int b) {
        int idx = 0, result = 0;
        Boolean neg = (str.charAt(0) == '-');
        if (neg) idx++;

        while (idx < str.length()) {
            result = (b * result) + (str.charAt(idx++) - '0');
        }

        if (neg) result = -result;
        return result;
    }

    private static String toString(int x, int b) {
        if (x == 0) return "0";

        StringBuilder sb = new StringBuilder();
        Boolean neg = false;
        if (x < 0) {
            x = -x;
            neg = true;
        }

        while (x > 0) {
            sb.append(x % b);
            x = x / b;
        }

        if (neg) sb.append('-');

        return sb.reverse().toString();
    }

    public static String convertBase(String in, int bIn, int bOut) {
        return toString(toInt(in, bIn), bOut);
    }

    public static void main(String[] args) {
        System.out.println(toInt("123"));
        System.out.println(toInt("-123"));
        System.out.println(fromInt(123));
        System.out.println(fromInt(-123));

        System.out.println(convertBase("101", 2, 10));
        System.out.println(convertBase("-15", 10, 2));
    }
}
