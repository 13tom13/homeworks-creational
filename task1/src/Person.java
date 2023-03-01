import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;

    protected final String surname;

    protected OptionalInt age;

    protected String address;

    private boolean hasAge = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
        hasAge = true;
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public boolean hasAge() {
        return hasAge;
    }

    public boolean hasAddress() {
        return (address != null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {

        this.age = OptionalInt.of(age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAddress(this.address);
        return child;
    }

    @Override
    public String toString() {
        return name;
    }

//    public String toString(){
//        StringBuilder s = new StringBuilder("Имя: " + name + " Фамилия: " + surname);
//        if (hasAge) s.append(" Возраст: " + age.getAsInt() + " лет");
//        if (hasAddress()) s.append(" Адресс: " + address);
//        return String.valueOf(s);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }


}
