package org.example;

public class PersonBuilder {
    private final Person person = new Person();
    public PersonBuilder setName(String name){
        person.setName(name);
        return this;
    }
    public PersonBuilder setPhone(String phone){
        person.setPhones(phone);
        return this;
    }

    public Person build(){
        return person;
    }
}
