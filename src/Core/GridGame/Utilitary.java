package Core.GridGame;

/**
 * Utilitary class for this Game Application
 * @author Adrien
 * @version 1.0
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
