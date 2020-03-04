package Belousov;

import lombok.Data;

@Data
public class Converter{
    public Human convert (HumanDto humanDto){
        Human human;
        human = new Human(humanDto.getId(),humanDto.getName(), humanDto.getBrithDate().getYear(), humanDto.getBrithDate().getMonth(),
                humanDto.getBrithDate().getDay(), humanDto.getAdress().getStreet(), humanDto.getAdress().getHouseNumber(),
                humanDto.getAdress().getFloorNumber(), humanDto.getAdress().getFlatNumber());
        return human;
    }

    public Human[] convert(HumanDto[] humansDto){
        Human[] humans = new Human[humansDto.length];
        for (int i = 0; i < humans.length; i ++){
            humans[i] = new Human(humansDto[i].getId(),humansDto[i].getName(), humansDto[i].getBrithDate().getYear(), humansDto[i].getBrithDate().getMonth(),
                    humansDto[i].getBrithDate().getDay(), humansDto[i].getAdress().getStreet(), humansDto[i].getAdress().getHouseNumber(),
                    humansDto[i].getAdress().getFloorNumber(), humansDto[i].getAdress().getFlatNumber());
        }
        return humans;
    }

    public HumanDto convert (Human human){
        HumanDto humanDto;
        humanDto = new HumanDto(human.getId(),human.getName(), human.getBrithDate().getYear(), human.getBrithDate().getMonth(),
                human.getBrithDate().getDay(), human.getAdress().getStreet(), human.getAdress().getHouseNumber(),
                human.getAdress().getFloorNumber(), human.getAdress().getFlatNumber());
        return humanDto;
    }

    public HumanDto[] convert (Human[] human){
        HumanDto[] humanDto = new HumanDto[human.length];
        for (int i = 0; i < humanDto.length; i ++){
            humanDto[i] = new HumanDto(human[i].getId(),human[i].getName(), human[i].getBrithDate().getYear(), human[i].getBrithDate().getMonth(),
                    human[i].getBrithDate().getDate(), human[i].getAdress().getStreet(), human[i].getAdress().getHouseNumber(),
                    human[i].getAdress().getFloorNumber(), human[i].getAdress().getFlatNumber());
        }
        return humanDto;
    }
}
