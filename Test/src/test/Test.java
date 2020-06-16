package test;

/**
 *
 * @author Sırrı Can KÖMÜR
 * @since 23.03.2020
 */
public class Test {

    public static void main(String[] args) {
        String randomNamesFile = "randomNames.txt";
        String personsFile = "persons.txt";
        Menu menu = new Menu();
        menu.createActionMenu(randomNamesFile, personsFile);
    }

}
