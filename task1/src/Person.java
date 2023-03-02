import java.util.*;

public class Person {

    protected final String name;

    protected final String surname;

    private OptionalInt age = OptionalInt.empty();

    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }


    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public boolean hasAge(){
        return age.isPresent();
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
        if (age.isPresent())
        this.age = OptionalInt.of(age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAddress(this.address);
        child.setAge(0);
        return child;
    }

    @Override
    public String toString() {
        return name;
    }
//
//    public String toString(){
//        StringBuilder s = new StringBuilder("Имя: " + name + " Фамилия: " + surname);
//        if (hasAge()) s.append(" Возраст: " + age.getAsInt() + " лет");
//        if (hasAddress()) s.append(" Адресс: " + address);
//        return String.valueOf(s);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }


}
