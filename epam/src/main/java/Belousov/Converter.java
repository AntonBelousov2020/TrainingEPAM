package Belousov;

public class Converter{

    public Human convertToHuman (HumanDto humanDto){
        Human human;
        human = new Human(humanDto.getId(),humanDto.getName(), humanDto.getBrithDate().getYear(), humanDto.getBrithDate().getMonth(),
                humanDto.getBrithDate().getDay(), humanDto.getAdress().getStreet(), humanDto.getAdress().getHouseNumber(),
                humanDto.getAdress().getFloorNumber(), humanDto.getAdress().getFlatNumber());
        return human;
    }

    public HumanDto convertToDto (Human human){
        HumanDto humanDto;
        humanDto = new HumanDto(human.getId(),human.getName(), human.getBrithDate().getYear(), human.getBrithDate().getMonth(),
                human.getBrithDate().getDay(), human.getAdress().getStreet(), human.getAdress().getHouseNumber(),
                human.getAdress().getFloorNumber(), human.getAdress().getFlatNumber());
        return humanDto;
    }
}
