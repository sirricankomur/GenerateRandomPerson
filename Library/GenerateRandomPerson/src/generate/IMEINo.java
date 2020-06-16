package generate;

public class IMEINo {

    private long IMEI;

    public long getIMEI() {
        return IMEI;
    }

    /**
     * Generates random IMEI Number.
     *
     * @return IMEI Returns a long data type.
     */
    public long generateIMEI() {
        long generatedNumber;

        Random rastgele = new Random();
        generatedNumber = rastgele.generateRandomThreeDigitNumber();
        generatedNumber = generatedNumber % 1000L;
        IMEI = ((generatedNumber * 98876532401L) + 124567987631L);
        findLastPlaceOfIMEI();

        return IMEI;
    }

    /**
     * Finds the last digit of the IMEI Number.
     */
    public void findLastPlaceOfIMEI() {
        long backupIMEI = IMEI;

        int placeValue;
        int placeCounter = 1;
        int sumOfSinglePlaceValue = 0;
        int sumOfDoublePlaceValue = 0;
        int sumOfPlaceValue;
        int lastPlaceValue;
        long remainder;
        int units;
        int tenth;
        int temp;
        long divisor = 10000000000000L;

        //Find the digits...
        while (divisor >= 1) {
            placeValue = (int) (IMEI / divisor);
            remainder = IMEI % divisor;
            IMEI = remainder;

            if (placeCounter % 2 != 0) {
                sumOfSinglePlaceValue += placeValue;

            } else if (placeCounter % 2 == 0) {
                temp = placeValue * 2;
                tenth = temp / 10;
                units = temp % 10;
                sumOfDoublePlaceValue += (tenth + units);
            }
            placeCounter++;
            divisor /= 10;
        }
        sumOfPlaceValue = sumOfDoublePlaceValue + sumOfSinglePlaceValue;
        lastPlaceValue = (10 - (sumOfPlaceValue % 10));

        if (lastPlaceValue == 10) {
            lastPlaceValue = 0;
        }

        IMEI = ((backupIMEI * 10) + lastPlaceValue);
    }

    /**
     * It validates the IMEI Number.
     *
     * @param IMEI IMEI number to be validated
     * @return Returns the validation result a String data type.
     */
    public String validateIMEINumber(long IMEI) {
        int placeValue;
        int placeCounter = 1;
        int sumOfSinglePlaceValue = 0;
        int sumOfDoublePlaceValue = 0;
        int sumOfPlaceValue;
        int foundLastPlaceValue;
        int lastPlaceValue = 0;
        long remainder;
        int units;
        int tenth;
        int temp;
        long divisor = 100000000000000L;

        //Find the digits...
        while (divisor >= 1) {
            placeValue = (int) (IMEI / divisor);
            remainder = IMEI % divisor;
            IMEI = remainder;

            if (placeCounter % 2 != 0) {

                if (placeCounter == 15) {
                    lastPlaceValue = placeValue;

                } else {
                    sumOfSinglePlaceValue += placeValue;
                }
            } else if (placeCounter % 2 == 0) {
                temp = placeValue * 2;
                tenth = temp / 10;
                units = temp % 10;
                sumOfDoublePlaceValue += (tenth + units);
            }
            placeCounter++;
            divisor /= 10;
        }

        sumOfPlaceValue = sumOfDoublePlaceValue + sumOfSinglePlaceValue;
        foundLastPlaceValue = (10 - (sumOfPlaceValue % 10));

        if (foundLastPlaceValue == 10) {
            foundLastPlaceValue = 0;
        }

        if (lastPlaceValue == foundLastPlaceValue) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

}
