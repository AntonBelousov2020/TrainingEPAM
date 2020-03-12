package Belousov;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class Service{

    private static int length = 3;//Размер массива Human

    RepositoryImpl repository;
    Converter converter;

    public Service(){

        repository = new RepositoryImpl();
        converter = new Converter();
    }

    public void service() throws ServiceExeption, ConverterExeption {


        log.info("Попытка подключения и запроса к базе данных");
        Human human = new Human();
        Human human1 = new Human();
        HumanDto humanDto1 = new HumanDto();
        HumanDto humanDto = new HumanDto();
        Human[] humans = new Human[length];
        Human[] humans1 = new Human[length];
        HumanDto[] humansDto = new HumanDto[length];
        Service service = new Service();
        //Получение одной сущности
        human = repository.getEntity(2);
        humanDto = converter.convertToDto(human);
        System.out.println(humanDto.toString());//Не убирать
        //Получение всех сущностей
        humans = repository.getAllEntity();
        for (int i = 0; i < length; i++) {
            humansDto[i] = converter.convertToDto(humans[i]);
            System.out.println(humansDto[i].toString());//Не убирать
        }
        //Добавление одной сущности
        human1 = converter.convertToHuman(humanDto);
        repository.setEntity(human1);
        System.out.println(human1.toString());
        //Добавление всех сущностей
        for (int i = 0; i < length; i++) {
            humans1[i] = converter.convertToHuman(humansDto[i]);
        }
        repository.setAllEntity(humans1);
        for (int i = 0; i < length; i++) {
            System.out.println(humans1[i]);
        }

        System.out.println("-------------------Exeptions!-------------------");
        try {
            repository.getEntity(10);
        } catch (ServiceExeption exeption){
            log.error(exeption.getMessage());
        }


        try {
            repository.setEntity(null);
        } catch (NullPointerException npe){
            log.error(npe.getMessage());
        }

        try {
            Converter converter = new Converter();
            converter.convertToDto(null);
        } catch (ConverterExeption ce){
            log.error(ce.getMessage());
        }
    }
}
