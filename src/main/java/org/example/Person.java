package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {

    public static class Builder {
        private final Person person = new Person();

        public Builder setName(String name) {
            person.setName(name);
            return this;
        }

        public Builder setPhone(String phone) {
            person.setPhones(phone);
            return this;
        }

        public Person build() {
            return person;
        }
    }
    private final List<String> phones = new ArrayList<>();
    private String name;

    public void setPhones(String phone) {
        this.phones.add(phone);
    }

    public List<String> getPhones() {
        return phones;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Имя: " + name + " -> Телефоны: " + phones;
    }
}
