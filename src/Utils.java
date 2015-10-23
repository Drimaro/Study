import java.util.Random;

/**
 * Created by konstantin.silin on 23.10.2015.
 */
public class Utils {

    public static int[] getRandomIntArray(int capacity){
        int[] result = new int[capacity];
        Random rand = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = rand.nextInt();
        }

        return result;
    }
}
