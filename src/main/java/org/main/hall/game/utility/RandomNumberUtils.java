package org.main.hall.game.utility;

/**
 * This class contains methods related to Random numbers
 */
public class RandomNumberUtils {

    /**
     * This will generate random number based on the range given
     *
     * @param minRangeNumber Minimum number of random number that this function can generate
     * @param maxRangeNumber Maximum number of random number that this function can generate
     * @return Will return random number based on the range given
     */
    public static int generateRandomNumberWithInRange(int minRangeNumber, int maxRangeNumber) {
        int range = maxRangeNumber - minRangeNumber + 1;
        return (int) (Math.random() * range) + minRangeNumber;
    }
}
