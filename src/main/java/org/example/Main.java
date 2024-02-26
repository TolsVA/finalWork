package org.example;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Main {
    public static void main(String[] args) {
        String lainName = "Конрад , Филипп , Шерлок , Харитон, Тимофей, Иосиф  , Устин  , Зенон  , Чарльз , Юлиан  , Шарль  , Леон   ";
        String[] arrName = lainName.split(", ");

        Map<String, Person> mapPersons = new MyHashMap<>();

        Main main = new Main();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String newName = main.getNewName(arrName, random);
            String newPhone = main.getNewPhone(random);

            if (mapPersons.containsKey(newName)) {
                mapPersons.get(newName).setPhones(newPhone);
            } else {
                Person person = new Person.Builder()
                        .setName(newName)
                        .setPhone(newPhone)
                        .build();
                mapPersons.put(person.getName(), person);
            }
        }

        System.out.println(mapPersons);
        main.sorted(mapPersons);
        List<Person> personArrayList = new ArrayList<>(mapPersons.values());
        main.print(main.bubbleSort(personArrayList));

        String searchName = main.getNewName(arrName, random);
        System.out.println(
                mapPersons.containsKey(searchName) ? mapPersons.get(searchName) : searchName + " нет такого персонажа"
        );
    }

    private void sorted(Map<String, Person> mapPersons) {
        List<Person> collect = mapPersons.values().stream()
                .sorted(comparingInt(e -> -e.getPhones().size()))
                .toList();
        collect.forEach(it -> System.out.println("\t" + it));
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
        int size = persons.size();
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < size; i++) {
                if (persons.get(i).getPhones().size() < persons.get(i - 1).getPhones().size()) {
                    Person temp = persons.get(i);
                    persons.set(i, persons.get(i - 1));
                    persons.set(i - 1, temp);
                    isSorted = false;
                }
            }
            size--;
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