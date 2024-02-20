package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<String> phones = new ArrayList<>();
    private String name;

    public void setPhones(String phone) {
        this.phones.add(phone);
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setName(String name) {
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
