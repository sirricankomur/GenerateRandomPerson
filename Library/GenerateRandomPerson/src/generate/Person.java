package generate;

public class Person {

    private IDNo idNo;
    private String firstName;
    private String lastName;
    private byte age;
    private Phone phoneNumber;

    /**
     * Constructor of the Persons class that creates the Random Person
     *
     * @param randomNamesFile File to select random names
     */
    public Person(String randomNamesFile) {
        Random rastgele = new Random();
        RandomPerson randomPerson = new RandomPerson(randomNamesFile);

        this.idNo = new IDNo();
        this.firstName = randomPerson.getRandomFirstName();
        this.lastName = randomPerson.getRandomLastName();
        this.age = (byte) (rastgele.generateRandomFourDigitNumber() % 100 + 1);
        this.phoneNumber = new Phone();
    }

    public IDNo getIDNo() {
        return idNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public byte getAge() {
        return age;
    }

    public Phone getPhoneNumber() {
        return phoneNumber;
    }
}
