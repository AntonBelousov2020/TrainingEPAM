package Belousov;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class HumanDto {

    private int id = 0;
    private String name;
    private Date brithDate;
    private Human.MyAdress adress;

    public HumanDto(int id ,String name, int year, int mounth, int date, String street, int houseNumber, int floorNumber, int flatNumber){
        this.id = id ++;
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new Human.MyAdress(street, houseNumber, floorNumber, flatNumber);
    }


    @Data
    @NoArgsConstructor
    protected static class dtoMyAdress{
        private String street;
        private int houseNumber, floorNumber, flatNumber;


        protected dtoMyAdress(String street, int houseNumber, int floorNumber, int flatNumber){
            this.street = street;
            this.houseNumber = houseNumber;
            this.floorNumber = floorNumber;
            this.flatNumber = flatNumber;
        }
    }

    public HumanDto createRandomHumanDto(){
        String[] nameRandom = {"Алексей","Иван","Михаил","Антон","Раимль"};
        int yearRandom = 1968 + (int) (Math.random()*52);
        int mounthRandom = 1 + (int) (Math.random()*11);
        int dateRandom = 1 + (int) (Math.random()*28);
        String streetRandom[] = {"Гая", "Юбилейная", "Свердлова", "Тополиная", "Советская"};
        int houseNumbeerRandom = 1 + (int) (Math.random()*50);
        int floorNumberRandom = 1 + (int) (Math.random()*15);
        int flatNumberRandom = 1 + (int) (Math.random()*227);
        HumanDto humanDto = new HumanDto(id++,nameRandom[(int)(Math.random()*nameRandom.length)], yearRandom, mounthRandom, dateRandom,
                streetRandom[(int) (Math.random()*streetRandom.length)], houseNumbeerRandom, floorNumberRandom, flatNumberRandom);
        return humanDto;
    }


    public String toStringHD(){
        String s;
        s = String.format("Имя %s, Дата рождения %s, Улица %s, Номер дома %d, Номер этажа %d, Номер квартиры %d", name, brithDate.toString(), adress.getStreet(), adress.getHouseNumber(), adress.getFloorNumber(), adress.getFlatNumber());
        return s;
    }
}
