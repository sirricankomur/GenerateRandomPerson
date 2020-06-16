package test;

import generate.IDNo;
import generate.IMEINo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Validation {

    /**
     * It verifies the ID No and IMEI No information in the file.
     *
     * @param names Where names to be read from the file will be saved to List.
     * @param identityNumbers ID Numbers to be read from the file will be saved
     * to List.
     * @param IMEINumbers IMEI Numbers to be read from the file will be saved to
     * List.
     */
    public void validateTCAndIMEI(LinkedList<String> names, LinkedList<String> identityNumbers, LinkedList<String> IMEINumbers, File file) {
        IDNo idNo = new IDNo();
        IMEINo imeiNo = new IMEINo();

        int counter = 1;
        long identityNumber = 0;
        String validatingIdentityNumber = null;
        long IMEINumber;
        String validatingIMEINumber;
        String firstName = null;
        String lastName = null;
        String operand = null;
        Scanner scanner;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                if (counter % 6 == 1) {
                    identityNumber = scanner.nextLong();
                    validatingIdentityNumber = idNo.validateIdentityNumber(identityNumber);
                } else if (counter % 6 == 2) {
                    firstName = scanner.next();
                } else if (counter % 6 == 3) {
                    lastName = scanner.next();
                    names.add(firstName + " " + lastName);
                } else if (counter % 6 == 0) {
                    String tempIMEI = scanner.next();
                    tempIMEI = tempIMEI.substring(1, 16);
                    IMEINumber = Long.parseLong(tempIMEI);
                    validatingIMEINumber = imeiNo.validateIMEINumber(IMEINumber);

                    identityNumbers.add(identityNumber + "  -->  " + validatingIdentityNumber);
                    IMEINumbers.add(IMEINumber + "  -->  " + validatingIMEINumber);
                } else {
                    operand = scanner.next();

                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
