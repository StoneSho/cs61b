/** Class that prints the Collatz sequence starting from a given number.
 *  @author StoneShaw
 */
public class Collatz {

    /** Correct implementation of nextNumber! */
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n / 2; // 偶数情况
        } else {
            return 3 * n + 1; // 奇数情况
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
