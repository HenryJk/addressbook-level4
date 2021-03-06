package seedu.address.commons.util;

import java.util.Random;

public class UniqueIdUtil {

    /*
     * Create a 100 character long randomly generated string (may include null character)
     */

    public static String createUniqueId(long seed) {
        byte[] byteArray = new byte[100];
        long millis = System.currentTimeMillis();
        Random generator = new Random(millis + seed);
        generator.nextBytes(byteArray);
        return new String(byteArray);
    }

    public static String createUniqueId() {
        return createUniqueId(0);
    }

}
