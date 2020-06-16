package test;

import java.io.FileWriter;
import java.io.IOException;
import generate.Person;
import generate.IMEINo;

public class PersonManager {

    /**
     * Creates the Contact randomly and saves the Contact to the parameter
     * received file.
     *
     * @param randomNamesFile File to select random names
     * @param personsFile File where created contacts will be saved
     */
    public void generateRandomPerson(String randomNamesFile, String personsFile) {
        Person person = new Person(randomNamesFile);
        IMEINo imeiNo = new IMEINo();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(personsFile, true);

            fileWriter.write(String.format("%d ", person.getIDNo().getIdentityNumber()));
            fileWriter.write(person.getFirstName() + " ");
            fileWriter.write(person.getLastName() + " ");
            fileWriter.write(person.getAge() + " ");
            fileWriter.write(String.format("0%d (%d)\n", person.getPhoneNumber().getTelephoneNumber(), imeiNo.generateIMEI()));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
