import java.util.Random;

public class Rand {
    static Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
