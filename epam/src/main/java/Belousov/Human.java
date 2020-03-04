package Belousov;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Human {
    private int id = 0;
    private String name;
    private Date brithDate;
    private MyAdress adress;

    public Human(int  id,String name, int year, int mounth, int date, String street, int houseNumber, int floorNumber, int flatNumber){
        this.id = id;
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new MyAdress(street, houseNumber, floorNumber, flatNumber);
    }

    public Human createRandomHuman(){
        String[] nameRandom = {"Алексей","Иван","Михаил","Антон","Раимль"};
        int yearRandom = 1968 + (int) Math.random()*52;
        int mounthRandom = 1 + (int) Math.random()*11;
        int dateRandom = 1 + (int) Math.random()*28;
        String streetRandom[] = {"Гая", "Юбилейная", "Свердлова", "Тополиная", "Советская"};
        int houseNumbeerRandom = 1 + (int) Math.random()*50;
        int floorNumberRandom = 1 + (int) Math.random()*15;
        int flatNumberRandom = 1 + (int) Math.random()*227;
        Human human = new Human(this.id, nameRandom[(int)(Math.random()*nameRandom.length)], yearRandom, mounthRandom, dateRandom,
                streetRandom[(int) (Math.random()*streetRandom.length)], houseNumbeerRandom, floorNumberRandom, flatNumberRandom);
        return human;
    }


@Data
@NoArgsConstructor
    protected static class MyAdress{
        private String street;
        private int houseNumber, floorNumber, flatNumber;


        protected MyAdress(String street, int houseNumber, int floorNumber, int flatNumber){
            this.street = street;
            this.houseNumber = houseNumber;
            this.floorNumber = floorNumber;
            this.flatNumber = flatNumber;
        }
    }


    public String toStringH(){
        String s;
        s = String.format("Имя %s, Дата рождения %s, Улица %s, Номер дома %d, Номер этажа %d, Номер квартиры %d", name, brithDate.toString(), adress.street, adress.houseNumber, adress.floorNumber, adress.flatNumber);
        return s;
    }
}
