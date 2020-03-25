package com.epam.belousov.human;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Human {
    private String firstName;
    private String secondName;
    private String patronymic;

    private Integer age;

    private MyAdress adress;

    public Human(String firstNameC, String secondNameC, String patronymicC, Integer ageC, String cityC, String streetC,
                 Integer numberHouseC, Integer numberFlatC) {
        this.firstName = firstNameC;
        this.secondName = secondNameC;
        this.patronymic = patronymicC;
        this.age = ageC;
        this.adress = new MyAdress(cityC, streetC, numberHouseC, numberFlatC);
    }

    @Data
    @NoArgsConstructor
    @ToString
    public class MyAdress implements Comparable<MyAdress> {
        private String city;
        private String street;

        private Integer numberHouse;
        private Integer flatNumber;

        public MyAdress(String cityC, String streetC, Integer numberHouseC, Integer flatNumberC) {
            this.city = cityC;
            this.street = streetC;
            this.numberHouse = numberHouseC;
            this.flatNumber = flatNumberC;
        }

        /**
         * This override method for compare to adress. Method must be realised in this scope because MyAdress is
         * inner class. Also this class include some fields
         *
         * @param myAdress - entry exemplar MyAdress class
         * @return - -1 or 0, or 1. 0 if fields instance variable adress into Human class is equal fields into MyAdress class,
         * -1 if fields instance variable adress into Human class smaller then fields into MyAdress class,
         * 1 if fields instance variable adress into Human class lager then fields into MyAdress class
         */
        @Override
        public int compareTo(MyAdress myAdress) {
            if (city.compareTo(myAdress.getCity()) != 0)
                return city.compareTo(myAdress.getCity());
            else if (street.compareTo(myAdress.getStreet()) != 0)
                return street.compareTo(myAdress.getStreet());
            else if (numberHouse.compareTo(myAdress.getNumberHouse()) != 0)
                return numberHouse.compareTo(myAdress.getNumberHouse());
            else return flatNumber.compareTo(myAdress.getFlatNumber());
        }
    }
}
