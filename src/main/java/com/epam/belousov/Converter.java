package com.epam.belousov;

public class Converter {

    /**
     * This method convert DTO to entity
     *
     * @param humanDto - entry DTO
     * @return human entity or exeption. Exeption is returned if entry parameter has been null
     */
    public Human convertToHuman(HumanDto humanDto) {
        if (humanDto == null) {
            throw new NullPointerException();
        }
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
        return human;
    }


    /**
     * This method convert entity to DTO
     *
     * @param human - entry entity
     * @return - human DTO or exeption. Exeption is returned if entry parameter has been null
     */
    public HumanDto convertToDto(Human human) {
        if (human == null) {
            throw new NullPointerException();
        }
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
        return humanDto;
    }
}
