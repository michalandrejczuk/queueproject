package queueproject;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private int counter;
    private String vipStr;
    private boolean isVip;

    public Person(String name, String surname, int counter, String vipStr) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.vipStr = vipStr;
    }

    public Person(String name, String surname, int counter) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        if (!isVip()) {
        return name + surname + counter;
    } else {
        return name + surname + counter + "_VIP";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return counter == person.counter && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, counter);
    }
}
