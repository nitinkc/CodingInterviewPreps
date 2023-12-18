package a0bitwise;

public class B7MultiplyWithoutOperator {

    public static void main(String[] args) {
        long x = 123456789L;
        long y = 987654321L;

        long result = multiplyLongNumbers(x, y);

        System.out.println("Multiplication Result: " + result);
    }

    private static long multiplyLongNumbers(long x, long y) {
        long result = 0;

        while (x != 0) {
            // Check the least significant bit of num1
            if ((x & 1) == 1) {
                result = add(result, y);
            }

            // Right shift num1, effectively dividing by 2
            x >>= 1;

            // Left shift num2, effectively multiplying by 2
            y <<= 1;
        }

        return result;
    }

    private static long add(long a, long b) {
        while (b != 0) {
            long carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}