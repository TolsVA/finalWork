package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String lainName = "Конрад , Филипп , Шерлок , Харитон, Тимофей, Иосиф  , Устин  , Зенон  , Чарльз , Юлиан  , Шарль  , Леон   ";
        String[] arrName = lainName.split(", ");

        Set<String> set = new HashSet<>();
        Map<String, Person> mapPersons = new MyHashMap<>();

        org.example.Main main = new org.example.Main();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String newName = main.getNewName(arrName, random);
            String newPhone = main.getNewPhone(random);

            if (set.contains(newName)) {
                mapPersons.get(newName).setPhones(newPhone);
            } else {
                Person person = new PersonBuilder()
                        .setName(newName)
                        .setPhone(newPhone)
                        .build();
                mapPersons.put(person.getName(), person);
                set.add(newName);
            }
        }
        System.out.println(mapPersons);
        List<Person> personArrayList = new ArrayList<>(mapPersons.values());
        main.print(main.bubbleSort(personArrayList));
    }

    private void print(List<Person> persons) {
        System.out.println("[");
        for (Person person : persons) {
            System.out.println("\t" + person);
        }
        System.out.println("]");
    }

    public List<Person> bubbleSort(List<Person> persons) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < persons.size(); i++) {
                if (persons.get(i).getPhones().size() > persons.get(i - 1).getPhones().size()) {
                    Person temp = persons.get(i);
                    persons.set(i, persons.get(i - 1));
                    persons.set(i - 1, temp);
                    isSorted = false;
                }
            }
        }
        return persons;
    }

    private String getNewPhone(Random random) {
        return "+7 " + (random.nextInt(99) + 900) +
                "-" + (random.nextInt(899) + 100) +
                "-" + (random.nextInt(89) + 10) +
                "-" + (random.nextInt(89) + 10);
    }

    private String getNewName(String[] arrName, Random random) {
        return arrName[random.nextInt(arrName.length - 1)];
    }
}