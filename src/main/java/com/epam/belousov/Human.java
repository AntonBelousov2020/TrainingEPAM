package com.epam.belousov;

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

    public Human(int id, String name, int year, int mounth, int date, String street, int houseNumber, int floorNumber, int flatNumber) {
        this.id = id++;
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new MyAdress(street, houseNumber, floorNumber, flatNumber);
    }

    @Data
    @NoArgsConstructor
    protected static class MyAdress {
        private String street;
        private int houseNumber;
        private int floorNumber;
        private int flatNumber;


        protected MyAdress(String street, int houseNumber, int floorNumber, int flatNumber) {
            this.street = street;
            this.houseNumber = houseNumber;
            this.floorNumber = floorNumber;
            this.flatNumber = flatNumber;
        }
    }

    /**
     * This method is override method toString for special format string
     *
     * @return formatted string representation entity
     */
    @Override
    public String toString() {
        return String.format("id %d, Имя %s, Дата рождения %s, Улица %s, Номер дома %d, Номер этажа %d, Номер квартиры %d",
                id,
                name,
                brithDate.toString(),
                adress.getStreet(),
                adress.getHouseNumber(),
                adress.getFloorNumber(),
                adress.getFlatNumber());
    }
}
