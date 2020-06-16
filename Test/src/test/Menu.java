package test;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    /**
     * Creates a menu and operations are defined.
     *
     * @param randomNamesFile File to select random names
     * @param personsFile File where created contacts will be saved
     */
    public void createActionMenu(String randomNamesFile, String personsFile) {
        int action = 0;
        Scanner input = new Scanner(System.in);

        while (action != 3) {

            System.out.println("1- Generate Random Person");
            System.out.println("2- Check Generated File");
            System.out.println("3- Exit");
            System.out.print(">>> ");
            action = input.nextInt();

            if (action == 1) {
                PersonManager person = new PersonManager();
                person.generateRandomPerson(randomNamesFile, personsFile);
                System.out.println("\nThe person was successfully produced.\n");
            } else if (action == 2) {
                checkGeneratedFile(personsFile);
            } else if (action == 3) {
                System.out.println("Exited.");
            } else {
                System.out.println("Please select a valid transaction!");
            }
        }
    }

    public void checkGeneratedFile(String personsFile) {
        File file = new File(personsFile);
        LinkedList<String> identityNumbers = new LinkedList<String>();
        LinkedList<String> IMEINumbers = new LinkedList<String>();
        LinkedList<String> names = new LinkedList<String>();
        Validation validation = new Validation();
        validation.validateTCAndIMEI(names, identityNumbers, IMEINumbers, file);
        printInformation(names, identityNumbers, IMEINumbers);
    }

    /**
     * Prints the information in the file.
     *
     * @param names Where names to be read from the file will be saved to List.
     * @param identityNumbers TC ID Numbers to be read from the file will be
     * recorded to List.
     * @param IMEINumbers IMEI Numbers to be read from the file will be saved to
     * List.
     */
    public void printInformation(LinkedList<String> names, LinkedList<String> identityNumbers, LinkedList<String> IMEINumbers) {
        int index = 0;
        int longest = 0;
        for (String name : names) {
            if (name.length() > longest) {
                longest = name.length();
            }
        }

        printIDInformation(names, identityNumbers, longest);
        printIMEIInformation(names, IMEINumbers, longest);

        System.out.print("\n");
    }

    public void printIDInformation(LinkedList<String> names, LinkedList<String> identityNumbers, int longest) {
        int index = 0;

        System.out.format("%" + (longest + 15) + "s %s %n", "IDENTITY NUMBER", "CONTROL");
        System.out.println("-------------------------------------------------------");
        System.out.format("%10s", "-FIRSTNAME & LASTNAME-");
        System.out.format("%" + (longest - 5) + "s      %s%n", "- ID -", "-VERIFICATION-");

        for (String name : names) {
            System.out.format("%-" + longest + "s         %s%n", name, identityNumbers.get(index));
            index++;
        }
    }

    public void printIMEIInformation(LinkedList<String> names, LinkedList<String> IMEINumbers, int longest) {
        int index = 0;

        System.out.print("\n\n");
        System.out.format("%" + (longest + 10) + "s %s %n", "IMEI", "CONTROL");
        System.out.println("-------------------------------------------------------");
        System.out.format("%10s", "-FIRSTNAME & LASTNAME-");
        System.out.format("%" + (longest - 1) + "s      %s%n", "- IMEI -", "-VERIFICATION-");
        for (String name : names) {
            System.out.format("%-" + longest + "s         %s%n", name, IMEINumbers.get(index));
            index++;
        }
    }

}
