package Belousov;

import lombok.EqualsAndHashCode;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

@EqualsAndHashCode
public class Service {

    private ArrayList<Human> list = new ArrayList<>();

    public void service() {

        //Создадим 10 записей
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

        //Заполним ArrayList этими объектами. Задание 1
        list.add(human1);
        list.add(human2);
        list.add(human3);
        list.add(human4);
        list.add(human5);
        list.add(human6);
        list.add(human7);
        list.add(human8);
        list.add(human9);
        list.add(human10);


        System.out.println("Весь ArrayList");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Найти дубли в коллекции и вывести их в консоль. Задание 2
        System.out.println("====================#######====================");
        System.out.println("Весь HashMap");
        HashMap<Integer, Human> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
        }
        System.out.println(map);

        System.out.println("====================#######====================");
        System.out.println("Повторы");

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) System.out.println(list.get(i));
            }
        }

        //Удалим дубли из коллеции, должно остаться 7 объектов. Задание 3
        System.out.println("====================#######====================");
        System.out.println("Без дублей");

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(list.get(j));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Отсортируем людей по ФИО. Задание 4
        System.out.println("====================#######====================");
        System.out.println("Сортировка по ФИО");
        CompareToName compareToName = new CompareToName();
        for (int i = 0; i < list.size(); i++) {
            list.sort(compareToName);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Отсортируем людей по возрасту. Задание 5
        System.out.println("====================#######====================");
        System.out.println("Сортировка по возрасту");
        CompareToAge compareToAge = new CompareToAge();
        for (int i = 0; i < list.size(); i++) {
            list.sort(compareToAge);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Отсортируем людей по адресу. Задание 6
        System.out.println("====================#######====================");
        System.out.println("Сортировка по адресу");
        CompareToAdress compareToAdress = new CompareToAdress();
        for (int i = 0; i < list.size(); i++) {
            list.sort(compareToAdress);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Создать класс User, добавить в него поля ФИО и роль,
        // которая является перечислением и содержит в себе ADMIN, USER, MODERATOR. Задание 7
        User user = new User("Ярандаев Иван Ирьевич", Roles.ADMIN);
        /*Напишем метод, в который входным значением будет являться объект класса User, метод должен на основании
        роли пользователя выводить приветственное сообщение, что-то вроде "Приветствуем с ролью + ОПИСАНИЕ_РОЛИ"
        описание роли пользователядолжно вычисляться на основании роли пользователя, запрещено использовать if и
        switch, а также описание роли в перечеслении. Задание 8*/
        System.out.println("====================#######====================");
        user.hellowUser();

        //Сортировка HashMap по ключу, создание и генерация данных какими захотим. Задание 9
        System.out.println("====================#######====================");
        System.out.println("Сортировка HashMap по ключу");
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int key;
        int value;
        System.out.println("До сортировки по ключу");
        for (int i = 0; i < 10 ; i++) {
            key = (int)(Math.random()*1000);
            value = (int)(Math.random()*10000);
            System.out.printf("%d=\t%d\n", key, value);
            hashMap.put(key, value);
        }
        System.out.println("После сортировки по ключу");

        TreeSet<Map.Entry<Integer, Integer>> keySortedSet = new TreeSet<>(new CompareToKey<>());
        keySortedSet.addAll(hashMap.entrySet());
        for (HashMap.Entry<Integer, Integer> entry : keySortedSet){
            System.out.printf("%d=\t%d\n", entry.getKey(), entry.getValue());
        }
        //Сортировка HashMap по значению, создание и генерация данных какими захотим. Задание 10
        key = 0;
        value = 0;
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < 10 ; i++) {
            key = (int)(Math.random()*1000);
            value = (int)(Math.random()*10000);
            System.out.printf("%d=\t%d\n", key, value);
            hashMap1.put(key, value);
        }
        System.out.println("После сортировки по значению");

        TreeSet<Map.Entry<Integer, Integer>> valueSortesdSet = new TreeSet<>(new CompareToValue<>());
        valueSortesdSet.addAll(hashMap1.entrySet());

        for (HashMap.Entry<Integer, Integer> entry1 : valueSortesdSet){
            System.out.printf("%d=\t%d\n", entry1.getKey(), entry1.getValue());
        }


        //Заполним рандомными значениями LinkedList, выведим содержимое каждого элемента и его индекс. Задание 11
        System.out.println("====================#######====================");
        System.out.println("Заполним LinkedList случайными значениями");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add((int)(Math.random()*1000));
        }

        for (Integer integer : linkedList){
            System.out.printf("linkedList[%d]= %-3d\n", linkedList.indexOf(integer), integer);
        }
    }
}
