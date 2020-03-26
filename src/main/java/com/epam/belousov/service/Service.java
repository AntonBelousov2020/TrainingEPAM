package com.epam.belousov.service;

import com.epam.belousov.exeptions.ConverterExeption;
import com.epam.belousov.exeptions.ServiceExeption;
import com.epam.belousov.repository.RepositoryImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {
    //Size array HumanDto
    private static final int LENGTH_ARR_DTO = 3;

    RepositoryImpl repository;
    Converter converter;

    public Service() {
        repository = new RepositoryImpl();
        converter = new Converter();
    }

    /**
     * This method realise main logic. In this method calling methods setting entities and getting DTO,
     * also convert method on other classes. This method also catch possible exeption
     * @throws ServiceExeption in case of entity with specified ID doesn't exist
     * @throws ConverterExeption in case of either entry parameter is null
     */
    public void service() throws ServiceExeption, ConverterExeption {
        log.info("Попытка подключения и запроса к базе данных");
        Human human;
        Human human1;
        HumanDto humanDto;
        Human[] humans;
        Human[] humans1 = new Human[LENGTH_ARR_DTO];
        HumanDto[] humansDto = new HumanDto[LENGTH_ARR_DTO];

        human = repository.getEntity(2);
        humanDto = converter.convertToDto(human);
        System.out.println(humanDto.toString());

        humans = repository.getAllEntities();
        for (int i = 0; i < LENGTH_ARR_DTO; i++) {
            humansDto[i] = converter.convertToDto(humans[i]);
            System.out.println(humansDto[i].toString());
        }

        human1 = converter.convertToHuman(humanDto);
        repository.setEntity(human1);
        System.out.println(human1.toString());

        for (int i = 0; i < LENGTH_ARR_DTO; i++) {
            humans1[i] = converter.convertToHuman(humansDto[i]);
        }
        repository.setAllEntities(humans1);
        for (int i = 0; i < LENGTH_ARR_DTO; i++) {
            System.out.println(humans1[i]);
        }

        System.out.println("-------------------Exeptions!-------------------");
        try {
            repository.getEntity(10);
        } catch (ServiceExeption exeption) {
            log.error(exeption.getMessage());
        }

        try {
            repository.setEntity(null);
        } catch (NullPointerException npe) {
            log.error(npe.getMessage());
        }

        try {
            Converter converter = new Converter();
            converter.convertToDto(null);
        } catch (ConverterExeption ce) {
            log.error(ce.getMessage());
        }
    }
}
