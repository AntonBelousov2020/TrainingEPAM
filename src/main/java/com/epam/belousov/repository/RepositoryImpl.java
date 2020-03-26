package com.epam.belousov.repository;

import com.epam.belousov.service.Human;
import com.epam.belousov.exeptions.ServiceExeption;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Data
@Slf4j
public class RepositoryImpl implements Repository<Human> {
    //Some imitation repository
    private LinkedList<Human> humanList = new LinkedList<Human>();

    public RepositoryImpl() {
        log.info("Успешное подключение к базе данных");
        for (int i = 0; i < 5; i++) {
            humanList.add(i, createRandomHuman(i));
        }
    }

    /**
     * This method create a random Human
     *
     * @param index - index of new Human
     * @return one random Human
     */
    private Human createRandomHuman(int index) {//Генерация сущностей
        String[] nameRandom = {"Алексей", "Иван", "Михаил", "Антон", "Раимль"};
        int yearRandom = 1968 + (int) (Math.random() * 52);
        int mounthRandom = 1 + (int) (Math.random() * 11);
        int dateRandom = 1 + (int) (Math.random() * 28);
        String streetRandom[] = {"Гая", "Юбилейная", "Свердлова", "Тополиная", "Советская"};
        int houseNumbeerRandom = 1 + (int) (Math.random() * 50);
        int floorNumberRandom = 1 + (int) (Math.random() * 15);
        int flatNumberRandom = 1 + (int) (Math.random() * 227);
        Human human = new Human(index, nameRandom[(int) (Math.random() * nameRandom.length)], yearRandom, mounthRandom, dateRandom,
                streetRandom[(int) (Math.random() * streetRandom.length)], houseNumbeerRandom, floorNumberRandom, flatNumberRandom);
        return human;
    }

    /**
     * This method getting one entity on repository
     *
     * @param index - entry index object on repository
     * @return one Human
     */
    public Human getEntity(int index) {
        if (index < 0 || index > humanList.size()) {
            throw new ServiceExeption("Сущности с таким id не существует");
        }
        Human human;
        human = humanList.get(index);

        log.info("Сущность успешно получена из базы");
        return human;
    }

    /**
     * This method getting all entities on repository
     *
     * @return array of Human
     */
    public Human[] getAllEntities() {
        Human[] humans = new Human[humanList.size()];
        for (int i = 0; i < humanList.size(); i++) {
            humans[i] = humanList.get(i);
        }
        log.info("\nВсе сущности успешно получены из базы");
        return humans;
    }

    /**
     * This method save one Human to repository
     *
     * @param entity - entry one Human
     */
    public void setEntity(Human entity) {//Сохранение одной
        if (entity == null) {
            throw new NullPointerException("Экземпляр не инициализирован");
        }
        humanList.add(entity);
        log.info("\nСущность успешно сохранена в базу данных");
    }

    /**
     * This method save all Human to repository
     *
     * @param entities - entry array of Human
     */
    public void setAllEntities(Human[] entities) {//Сохранение всех DTO в entity

        for (int i = 0; i < entities.length; i++) {
            humanList.add(entities[i]);
        }
        log.info("\nВсе сущности успешно сохранены в базу данных");
    }
}
