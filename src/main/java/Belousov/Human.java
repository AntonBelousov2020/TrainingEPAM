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
        this.id = id++;
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new MyAdress(street, houseNumber, floorNumber, flatNumber);
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


    @Override
    public String toString(){
        String s;
        s = String.format("id %d,Имя %s, Дата рождения %s, Улица %s, Номер дома %d, Номер этажа %d, Номер квартиры %d", id,name, brithDate.toString(), adress.street, adress.houseNumber, adress.floorNumber, adress.flatNumber);
        return s;
    }
}
