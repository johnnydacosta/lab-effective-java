package ch.jdc.autoboxing;
import ch.jdc.internal.Timer;

public class Autoboxing {

    public static long badSum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static long goodSum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Timer t = Timer.of();

        // Autoboxing
        t.start();
        System.out.println("BAD SUM...");
        Autoboxing.badSum();
        t.stop();
        System.out.println("Elapsed time [ms]: "  + t.getElapsedTimeInMillis());

        t.start();
        System.out.println("GOOD SUM...");
        Autoboxing.goodSum();
        t.stop();
        System.out.println("Elapsed time [ms]: "  + t.getElapsedTimeInMillis());
    }
}
