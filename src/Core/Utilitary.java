package Core;

/**
 *
 * @author Adrien
 */
public class Utilitary {

    /**
     * Static function that returns an integer between the two limits min and
     * max
     *
     * @param min Lower limit/Minimum
     * @param max Upper limit/Maximum
     * @return int Integer between min and max, both included
     */
    public static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
