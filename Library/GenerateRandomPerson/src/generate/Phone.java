package generate;

public class Phone {

    private long telephoneNumber;

    public Phone() {
        this.telephoneNumber = generateTelephoneNumber();
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Generates a random Phone number.
     *
     * @return telephoneNumber Returns a long data type.
     */
    public long generateTelephoneNumber() {
        Random rastgele = new Random();
        int generatedNumber = ((rastgele.generateRandomFourDigitNumber() % 1000) + 1);
        int mobilePrefix = generateMobilePrefix(generatedNumber);
        long localNumber = generateLocalNumber(generatedNumber);
        telephoneNumber = ((mobilePrefix * 10000000L) + localNumber);

        return telephoneNumber;
    }

    /**
     * Creates a Mobile Phone prefix (Top 3 digits).
     *
     * @param generatedNumber A random number greater than 30
     * @return mobilePrefix Returns the integer data type.
     */
    public int generateMobilePrefix(long generatedNumber) {
        int[] mobilePrefixes = new int[]{
            501, 505, 506, 507, 551, 552, 553, 554, 555, 559,
            530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 561,
            540, 541, 542, 543, 544, 545, 546, 547, 548, 549,};
        int mobilePrefix = 0;
        int counter = 0;
        int index = (int) (generatedNumber % 31);

        for (int prefix : mobilePrefixes) {
            if (index == counter) {
                mobilePrefix = prefix;
            }
            counter++;
        }
        return mobilePrefix;
    }

    /**
     * Generates Mobile Phone Local Number (Last 7 digits).
     *
     * @param generatedNumber A random number
     * @return localNumber Returns long type data.
     */
    public long generateLocalNumber(long generatedNumber) {
        return generatedNumber * 9973;
    }

}
