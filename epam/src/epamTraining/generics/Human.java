package epamTraining.generics;

import java.util.Date;

public class Human {
    private static int id = 0;
    private String name;
    private Date brithDate;
    private MyAdress adress;

    public Human(String name, int year, int mounth, int date, String street, int houseNumber, int floorNumber, int flatNumber){
        this.id = id ++;
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new MyAdress(street, houseNumber, floorNumber, flatNumber);
    }


    public Date getBrithDate() {
        return brithDate;
    }


    protected static class MyAdress{
        private String street;
        private int houseNumber, floorNumber, flatNumber;

        protected MyAdress(){
            this.street = "";
            this.houseNumber = 0;
            this.floorNumber = 0;
            this.flatNumber = 0;
        }

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
