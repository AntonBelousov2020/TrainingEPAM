package com.epam.belousov.service;

import com.epam.belousov.converter.Converter;
import com.epam.belousov.dto.HumanDto;
import com.epam.belousov.entity.Human;
import com.epam.belousov.repository.Repository;

import java.util.LinkedList;

public class Service implements Repository<Human, HumanDto> {
    //Size array HumanDto
    private static final int LENGTH_ARR_DTO = 3;
    //Some imitation repository
    private LinkedList<Human> humanList = new LinkedList<Human>();

    /**
     * This method realise main logic. In this method creating random DTO, and calling methods
     * setting entities and getting DTOs
     */
    public void service() {
        HumanDto[] humansDto = new HumanDto[LENGTH_ARR_DTO];

        for (int i = 0; i < LENGTH_ARR_DTO; i++) {
            humansDto[i] = this.createRandomHumanDto(i);
        }

        Service service = new Service();
        service.setEntity(humansDto[0]);
        service.setAllEntitys(humansDto);

        service.getEntity(2);
        service.getAllEntitys();
    }

    /**
     * This method create a random DTO
     *
     * @param index - index of new DTO
     * @return one random DTO
     */
    private HumanDto createRandomHumanDto(int index) {
        Human human = new Human();
        String[] nameRandom = {"Алексей", "Иван", "Михаил", "Антон", "Раимль"};
        int yearRandom = 1968 + (int) (Math.random() * 52);
        int mounthRandom = 1 + (int) (Math.random() * 11);
        int dateRandom = 1 + (int) (Math.random() * 28);
        String streetRandom[] = {"Гая", "Юбилейная", "Свердлова", "Тополиная", "Советская"};
        int houseNumbeerRandom = 1 + (int) (Math.random() * 50);
        int floorNumberRandom = 1 + (int) (Math.random() * 15);
        int flatNumberRandom = 1 + (int) (Math.random() * 227);
        HumanDto humanDto = new HumanDto(index, nameRandom[(int) (Math.random() * nameRandom.length)], yearRandom, mounthRandom, dateRandom,
                streetRandom[(int) (Math.random() * streetRandom.length)], houseNumbeerRandom, floorNumberRandom, flatNumberRandom);
        return humanDto;
    }

    /**
     * This method getting one entity on repository
     *
     * @param index - entry index entity on repository
     * @return one DTO
     */
    public HumanDto getEntity(int index) {
        if (index < 0 | index > humanList.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println("Geting one entity");
        Converter converter = new Converter();
        HumanDto humanDto;
        Human human = humanList.get(index);
        humanDto = converter.convertToDto(human);
        System.out.println(humanDto.toString());
        return humanDto;
    }

    /**
     * This method getting all entities on repository
     *
     * @return array of DTO
     */
    public HumanDto[] getAllEntitys() {
        System.out.println("Getting all entities");
        Converter converter = new Converter();
        Human[] humans = new Human[humanList.size()];
        for (int i = 0; i < humanList.size(); i++) {
            humans[i] = humanList.get(i);
        }
        HumanDto[] humansDto = new HumanDto[humanList.size()];
        for (int i = 0; i < humanList.size(); i++) {
            humansDto[i] = converter.convertToDto(humans[i]);
            System.out.println(humansDto[i].toString());
        }
        return humansDto;
    }

    /**
     * This method save one DTO to repository
     *
     * @param humanDto - entry one DTO
     */
    public void setEntity(HumanDto humanDto) {
        if (humanDto == null) {
            throw new NullPointerException();
        }
        Converter converter = new Converter();
        Human human = converter.convertToHuman(humanDto);
        System.out.println("One entity saved");
        System.out.println(human.toString());
        humanList.add(human);
    }

    /**
     * This method save all DTO to repository
     *
     * @param humansDto - entry array of DTO
     */
    public void setAllEntitys(HumanDto[] humansDto) {
        if (humansDto == null) {
            throw new NullPointerException();
        }
        Converter converter = new Converter();
        Human[] humans = new Human[humansDto.length];
        System.out.println("All entities saved");
        for (int i = 0; i < humansDto.length; i++) {
            humans[i] = converter.convertToHuman(humansDto[i]);
            humanList.add(humans[i]);
            System.out.println(humans[i].toString());
        }
    }
}
