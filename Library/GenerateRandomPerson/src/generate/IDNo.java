package generate;

public class IDNo {

    private long identityNumber;

    public IDNo() {
        identityNumber = generateIdentityNumber();
    }

    public long getIdentityNumber() {
        return identityNumber;
    }

    /**
     * Generates a random ID number.
     *
     * @return identityNumber returns a long data type.
     */
    public long generateIdentityNumber() {
        long generatedNumber;
        Random rastgele = new Random();
        generatedNumber = rastgele.generateRandomFourDigitNumber();
        identityNumber = (generatedNumber * 99991L);
        findLastDigitsOfIdentityNumber();

        return identityNumber;
    }

    /**
     * Finds the last two digits of the ID Number and generates the verified ID
     * number.
     */
    public void findLastDigitsOfIdentityNumber() {
        long backupTC = identityNumber;

        int placeValue;
        int placeCounter = 1;
        int sumOfSinglePlaceValue = 0;
        int sumOfDoublePlaceValue = 0;
        int resultOfOperation;
        int tensDigit;
        int unitsDigit;
        long remainder;
        long divisor = 100000000L;

        //Find the digits...
        while (divisor >= 1) {
            placeValue = (int) (identityNumber / divisor);
            remainder = identityNumber % divisor;
            identityNumber = remainder;

            if (placeCounter % 2 != 0) {
                sumOfSinglePlaceValue += placeValue;

            } else if (placeCounter % 2 == 0) {
                sumOfDoublePlaceValue += placeValue;
            }
            placeCounter++;
            divisor /= 10;
        }

        resultOfOperation = (sumOfSinglePlaceValue * 7) - sumOfDoublePlaceValue;
        tensDigit = (resultOfOperation % 10);
        unitsDigit = ((sumOfSinglePlaceValue + sumOfDoublePlaceValue + resultOfOperation) % 10);

        identityNumber = ((backupTC * 100) + (tensDigit * 10) + unitsDigit);
    }

    /**
     * It validates the Identity Number.
     *
     * @param identityNumber ID number to be validated
     * @return Returns the validation result a String data type.
     */
    public String validateIdentityNumber(long identityNumber) {
        int placeValue;
        int placeCounter = 1;
        int sumOfSinglePlaceValue = 0;
        int sumOfDoublePlaceValue = 0;
        int resultOfOperation;
        int unitsDigit = 0;
        int tensDigit = 0;
        int foundUnitsDigit;
        int foundTensDigit;
        long remainder;
        long divisor = 10000000000L;

        //Find the digits...
        while (divisor >= 1) {
            placeValue = (int) (identityNumber / divisor);
            remainder = identityNumber % divisor;
            identityNumber = remainder;

            if (placeCounter % 2 != 0) {

                if (placeCounter < 10) {
                    sumOfSinglePlaceValue += placeValue;

                } else if (placeCounter == 11) {
                    unitsDigit = placeValue;
                }
            } else if (placeCounter % 2 == 0) {

                if (placeCounter < 10) {
                    sumOfDoublePlaceValue += placeValue;

                } else if (placeCounter == 10) {
                    tensDigit = placeValue;
                }
            }
            placeCounter++;
            divisor /= 10;
        }

        resultOfOperation = (sumOfSinglePlaceValue * 7) - sumOfDoublePlaceValue;
        foundTensDigit = (resultOfOperation % 10);
        foundUnitsDigit = ((sumOfSinglePlaceValue + sumOfDoublePlaceValue + resultOfOperation) % 10);

        if (tensDigit == foundTensDigit && unitsDigit == foundUnitsDigit) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }
}
