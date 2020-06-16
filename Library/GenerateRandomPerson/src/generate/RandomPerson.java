package generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RandomPerson {

    private String randomFirstName;
    private String randomLastName;

    /**
     * Constructor of the RandomPerson class that creates the Random Person
     *
     * @param randomNamesFile File to select random names
     */
    public RandomPerson(String randomNamesFile) {
        randomPerson(randomNamesFile);
    }

    public String getRandomFirstName() {
        return randomFirstName;
    }

    public String getRandomLastName() {
        return randomLastName;
    }

    /**
     * The parameter selects randomly from the received file.
     *
     * @param randomNamesFile File to select random names
     */
    public void randomPerson(String randomNamesFile) {
        int counter = 1;
        long randomNumber;

        Random rastgele = new Random();
        File file = new File(randomNamesFile);
        Scanner scanner = null;
        String operand = null;
        try {
            randomNumber = rastgele.generateRandomFourDigitNumber() % 3000;
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                if (counter == randomNumber) {
                    randomFirstName = scanner.next();
                    randomLastName = scanner.next();
                }
                counter++;
                operand = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }

}
