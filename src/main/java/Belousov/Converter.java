package Belousov;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Converter {

    public Human convertToHuman (HumanDto humanDto) throws ConverterExeption{
        Human human;
        human = new Human(humanDto.getId(),
                humanDto.getName(),
                humanDto.getBrithDate().getYear(),
                humanDto.getBrithDate().getMonth(),
                humanDto.getBrithDate().getDay(),
                humanDto.getAdress().getStreet(),
                humanDto.getAdress().getHouseNumber(),
                humanDto.getAdress().getFloorNumber(),
                humanDto.getAdress().getFlatNumber());

        log.info("Конвертация из DTO в Entity прошла успешно");
        return human;
    }

    public HumanDto convertToDto (Human human) throws ConverterExeption{

        HumanDto humanDto;
        humanDto = new HumanDto(human.getId(),
                human.getName(),
                human.getBrithDate().getYear(),
                human.getBrithDate().getMonth(),
                human.getBrithDate().getDay(),
                human.getAdress().getStreet(),
                human.getAdress().getHouseNumber(),
                human.getAdress().getFloorNumber(),
                human.getAdress().getFlatNumber());

        log.info("Конвертация из Entity в DTO прошла успешно");
        return humanDto;
    }
}
