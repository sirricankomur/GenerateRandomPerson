package generate;

import java.util.Date;

public class Random {

    private long randomNumber = 0;
    private int placeValue = 0;
    private long remainder = 0;
    private int placeCounter = 0;
    private boolean thousandsPlace = false;
    private long divisor = 10000000000000L;

    /**
     * Generates a four-digit random number.
     *
     * @return randomNumber Returns the integer data type.
     */
    public int generateRandomFourDigitNumber() {
        randomNumber = new Date().getTime();

        //Find the digits...
        while (divisor > 1) {

            if (placeCounter < 10) {
                placeValue = (int) (randomNumber / divisor);
                remainder = randomNumber % divisor;
                randomNumber = remainder;

            } else if (placeCounter == 10) {
                placeValue = (int) (randomNumber / divisor);

                if (placeValue == 0) {
                    thousandsPlace = true;
                }
            }
            checkThousandPlace();

            placeCounter++;
            divisor /= 10;
        }
        return (int) randomNumber;
    }

    /**
     * Generates a three-digit random number.
     *
     * @return randomNumber Returns the integer data type.
     */
    public int generateRandomThreeDigitNumber() {
        randomNumber = new Date().getTime();

        //Find the digits...
        while (divisor > 1) {

            if (placeCounter < 11) {
                placeValue = (int) (randomNumber / divisor);
                remainder = randomNumber % divisor;
                randomNumber = remainder;

            } else if (placeCounter == 11) {
                placeValue = (int) (randomNumber / divisor);

                if (placeValue == 0) {
                    thousandsPlace = true;
                }
            }
            checkThousandPlace();

            placeCounter++;
            divisor /= 10;
        }
        return (int) randomNumber;
    }

    /**
     * Checks if the thousands of digits of the four-digit number are zero.
     */
    public void checkThousandPlace() {

        if (thousandsPlace == true) {
            randomNumber = new Date().getTime();
            thousandsPlace = false;
            divisor = 10000000000000L;
            placeCounter = 0;
        }
    }

}
