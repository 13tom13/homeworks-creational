
public class PersonBuilder {
    private String name;

    private String surname;

    private int age;

    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else if (age <= 0) {
            throw new IllegalArgumentException("Введен не допустимый возраст");
        } else if (age > 120) {
            throw new IllegalArgumentException("Столько не живут!");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) throw new IllegalStateException("Имя не введено!");
        if (surname == null) throw new IllegalStateException("Фамилия не введена не введено!");
        return new Person(name, surname, age, address);
    }


}
