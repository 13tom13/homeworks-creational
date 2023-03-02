import java.util.OptionalInt;

public class PersonBuilder {

    private String name;

    private String surname;

    private OptionalInt age = OptionalInt.empty();

    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Введен не допустимый возраст");
        } else if (age > 120) {
            throw new IllegalArgumentException("Столько не живут!");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public Person build (){
        Person person;
        if (name == null) throw new  IllegalStateException("Имя не введено!");
        if (surname == null) throw new  IllegalStateException("Фамилия не введена!");
        if (age.isPresent()) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);
        return person;
    }

}
