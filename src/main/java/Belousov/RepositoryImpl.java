package Belousov;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Data
@Slf4j

public class RepositoryImpl implements Repository <Human> {

    private static int length = 3;//Размер массива Human
    private LinkedList<Human> list = new LinkedList<Human>();

    public RepositoryImpl(){

        log.info("Успешное подключение к базе данных");
        for (int i = 0; i < 5; i++) {
            list.add(i, createRandomHuman(i));
        }
    }

    public Human getEntity(int index) {//Получение одной сущности из базы

        Human human = createRandomHuman(index);
        human = list.get(index);
        log.info("Сущность успешно получена из базы");
        return human;
    }

    public Human[] getAllEntity() {//Получение всех сущностей из базы

        Human[] humans = new Human[list.size()];
        for (int i = 0; i < list.size(); i++){
            humans[i] = createRandomHuman(i);
            humans[i] = list.get(i);
        }
        log.info("\nВсе сущности успешно получены из базы");
        return humans;
    }

    public void setEntity(Human entity) {//Сохранение одной

        list.add(entity);
        log.info("\nСущность успешно сохранена в базу данных");
    }

    public void setAllEntity(Human[] entitys) {//Сохранение всех DTO в entyty

        for (int i = 0; i < entitys.length; i ++){
            list.add(entitys[i]);
        }
        log.info("\nВсе сущности успешно сохранены в базу данных");
    }

    private Human createRandomHuman(int index){//Генерация сущностей

        String[] nameRandom = {"Алексей","Иван","Михаил","Антон","Раимль"};
        int yearRandom = 1968 + (int) (Math.random()*52);
        int mounthRandom = 1 + (int) (Math.random()*11);
        int dateRandom = 1 + (int) (Math.random()*28);
        String streetRandom[] = {"Гая", "Юбилейная", "Свердлова", "Тополиная", "Советская"};
        int houseNumbeerRandom = 1 + (int) (Math.random()*50);
        int floorNumberRandom = 1 + (int) (Math.random()*15);
        int flatNumberRandom = 1 + (int) (Math.random()*227);
        Human human = new Human(index,nameRandom[(int)(Math.random()*nameRandom.length)], yearRandom, mounthRandom, dateRandom,
                streetRandom[(int) (Math.random()*streetRandom.length)], houseNumbeerRandom, floorNumberRandom, flatNumberRandom);
        return human;
    }
}
