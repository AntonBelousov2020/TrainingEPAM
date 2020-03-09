package Belousov;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data//set и get
@NoArgsConstructor
@ToString
public class Human {

    //ФИО
    private String firstName;
    private String secondName;
    private String patronymic;

    //Возраст
    private Integer age;

    //Адрес
    private MyAdress adress;

    public Human(String firstNameC, String secondNameC, String patronymicC, Integer ageC, String cityC, String streetC,
                 Integer numberHouseC, Integer numberFlatC){
        this.firstName = firstNameC;
        this.secondName = secondNameC;
        this.patronymic = patronymicC;
        this.age = ageC;
        this.adress = new MyAdress(cityC, streetC, numberHouseC, numberFlatC);
    }

    //Вложенный класс адрес
    @Data//set и get
    @NoArgsConstructor
    @ToString
    protected class MyAdress implements Comparable<MyAdress>{

        //Поля город и улица
        private String city, street;

        //Поля дом и квартира
        private Integer numberHouse, flatNumber;

        protected MyAdress(String cityC, String streetC, Integer numberHouseC, Integer flatNumberC){
            this.city = cityC;
            this.street = streetC;
            this.numberHouse = numberHouseC;
            this.flatNumber = flatNumberC;
        }

        @Override
        public int compareTo(MyAdress myAdress) {
            if(city.compareTo(myAdress.getCity()) != 0) return city.compareTo(myAdress.getCity());
            else if (street.compareTo(myAdress.getStreet()) != 0) return street.compareTo(myAdress.getStreet());
            else if (numberHouse.compareTo(myAdress.getNumberHouse()) != 0) return numberHouse.compareTo(myAdress.getNumberHouse());
            else return flatNumber.compareTo(myAdress.getFlatNumber());
        }
    }
}
