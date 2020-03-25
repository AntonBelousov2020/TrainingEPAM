package com.epam.belousov.service;

import com.epam.belousov.human.Human;
import com.epam.belousov.comparators.*;
import lombok.EqualsAndHashCode;

import java.util.*;

@EqualsAndHashCode
public class Service {
    private ArrayList<Human> humanList = new ArrayList<>();

    /**
     * This method realise main logic. On this method calling all other methods from other classes. Also in this method
     * generate new Humans and fill them on LinkedList. In this method also are carried out some tasks
     */
    public void service() {
        Human human1 = new Human("Андрей", "Акатьев", "Викторович",
                28, "Казань", "Свердлова", 7, 28);
        Human human2 = new Human("Андрей", "Акатьев", "Викторович",
                28, "Казань", "Свердлова", 7, 28);//Дубль1
        Human human3 = new Human("Александр", "Неборак", "Викторович",
                24, "Тольятти", "Свердлова", 7, 28);
        Human human4 = new Human("Александр", "Неборак", "Викторович",
                24, "Тольятти", "Свердлова", 7, 28);//Дубль2
        Human human5 = new Human("Анастасия", "Кольцова", "Александровна",
                22, "Тольятти", "Детский проезд", 34, 1);
        Human human6 = new Human("Екатерина", "Кандрашкина", "Викторовна",
                22, "Тольятти", "Белорусская", 16, 4);
        Human human7 = new Human("Иван", "Ярандаев", "Юрьевич",
                22, "Тольятти", "Гаражный проезд", 4, 1);//Дубль3
        Human human8 = new Human("Иван", "Ярандаев", "Юрьевич",
                22, "Тольятти", "Гаражный проезд", 4, 1);
        Human human9 = new Human("Елизавета", "Андреева", "Александровна",
                22, "Тольятти", "Свердлова", 7, 12);
        Human human10 = new Human("Олег", "Дуганцов", "Юрьевич",
                22, "Тольятти", "Автостроителей", 8, 54);

        //Fill in ArrayList these objects. Task 1
        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);
        humanList.add(human4);
        humanList.add(human5);
        humanList.add(human6);
        humanList.add(human7);
        humanList.add(human8);
        humanList.add(human9);
        humanList.add(human10);


        System.out.println("Весь ArrayList");
        for (int i = 0; i < humanList.size(); i++) {
            System.out.println(humanList.get(i));
        }

        //Find doubling in Collection and show doubling on console. Task 2
        System.out.println("====================#######====================");
        System.out.println("Весь HashMap");
        HashMap<Integer, Human> map = new HashMap<>();
        for (int i = 0; i < humanList.size(); i++) {
            map.put(i, humanList.get(i));
        }
        System.out.println(map);

        System.out.println("====================#######====================");
        System.out.println("Повторы");

        for (int i = 0; i < humanList.size() - 1; i++) {
            for (int j = i + 1; j < humanList.size(); j++) {
                if (humanList.get(i).equals(humanList.get(j))) {
                    System.out.println(humanList.get(i));
                }
            }
        }

        //Remove doubling on Collection, should stay 7 objects. Task 3
        System.out.println("====================#######====================");
        System.out.println("Без дублей");

        for (int i = 0; i < humanList.size() - 1; i++) {
            for (int j = i + 1; j < humanList.size(); j++) {
                if (humanList.get(i).equals(humanList.get(j))) {
                    humanList.remove(humanList.get(j));
                }
            }
        }
        for (int i = 0; i < humanList.size(); i++) {
            System.out.println(humanList.get(i));
        }

        //Sort Collection by full name. Task 4
        System.out.println("====================#######====================");
        System.out.println("Сортировка по ФИО");
        CompareToName compareToName = new CompareToName();
        for (int i = 0; i < humanList.size(); i++) {
            humanList.sort(compareToName);
        }

        for (int i = 0; i < humanList.size(); i++) {
            System.out.println(humanList.get(i));
        }

        //Sort Collection by age. Task 5
        System.out.println("====================#######====================");
        System.out.println("Сортировка по возрасту");
        CompareToAge compareToAge = new CompareToAge();
        for (int i = 0; i < humanList.size(); i++) {
            humanList.sort(compareToAge);
        }

        for (int i = 0; i < humanList.size(); i++) {
            System.out.println(humanList.get(i));
        }

        //Sort Collection by address. Task 6
        System.out.println("====================#######====================");
        System.out.println("Сортировка по адресу");
        CompareToAdress compareToAdress = new CompareToAdress();
        for (int i = 0; i < humanList.size(); i++) {
            humanList.sort(compareToAdress);
        }

        for (int i = 0; i < humanList.size(); i++) {
            System.out.println(humanList.get(i));
        }

        //Create User class, add on this class field full name and role,
        // this role is enum and. This enum contains roles ADMIN, USER, MODERATOR. Task 7
        User user = new User("Ярандаев Иван Юрьевич", Roles.ADMIN);

        /*Realise method, in this method input argument is User class object, method must based on user role
        show hello message, for example "Приветствуем с ролью + ОПИСАНИЕ_РОЛИ"
        user role description must determined based on user role, forbidden to use if and
        switch, also forbidden to use role description on enum. Task 8*/
        System.out.println("====================#######====================");
        user.helloUser();

        //Sort HashMap by key, creating and generating data as we want. Task 9
        System.out.println("\n====================#######====================");
        System.out.println("Сортировка HashMap по ключу");
        HashMap<Integer, Integer> hashMapByKey = new HashMap<>();

        int key;
        int value;
        System.out.println("До сортировки по ключу");
        for (int i = 0; i < 10; i++) {
            key = (int) (Math.random() * 1000);
            value = (int) (Math.random() * 10000);
            System.out.printf("%d=\t%d\n", key, value);
            hashMapByKey.put(key, value);
        }
        System.out.println("После сортировки по ключу");

        TreeSet<Map.Entry<Integer, Integer>> keySortedSet = new TreeSet<>(new CompareToKey<>());
        keySortedSet.addAll(hashMapByKey.entrySet());
        for (HashMap.Entry<Integer, Integer> entryKey : keySortedSet) {
            System.out.printf("%d=\t%d\n", entryKey.getKey(), entryKey.getValue());
        }

        //Sort HashMap by value, creating and generating data as we want. Task 10
        key = 0;
        value = 0;
        System.out.println("До сотировки по значению");
        HashMap<Integer, Integer> hashMapByValue = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            key = (int) (Math.random() * 1000);
            value = (int) (Math.random() * 10000);
            System.out.printf("%d=\t%d\n", key, value);
            hashMapByValue.put(key, value);
        }
        System.out.println("После сортировки по значению");

        TreeSet<Map.Entry<Integer, Integer>> valueSortedSet = new TreeSet<>(new CompareToValue<>());
        valueSortedSet.addAll(hashMapByValue.entrySet());

        for (HashMap.Entry<Integer, Integer> entryValue : valueSortedSet) {
            System.out.printf("%d=\t%d\n", entryValue.getKey(), entryValue.getValue());
        }


        //Fill in random value on LinkedList, show content every element and index of element. Task 11
        System.out.println("====================#######====================");
        System.out.println("Заполним LinkedList случайными значениями");
        LinkedList<Integer> randomLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            randomLinkedList.add((int) (Math.random() * 1000));
        }

        for (Integer integer : randomLinkedList) {
            System.out.printf("linkedList[%d]= %-3d\n", randomLinkedList.indexOf(integer), integer);
        }
    }
}
