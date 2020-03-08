package epamTraining.generics;

import java.util.Date;
import epamTraining.generics.Human;
import epamTraining.generics.Human.MyAdress;

public class humanDTO {
    private String name;
    private Date brithDate;
    private MyAdress adress;


    public humanDTO(String name, int year, int mounth, int date, String street, int houseNumber, int floorNumber, int flatNumber){
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new MyAdress(street, houseNumber, floorNumber, flatNumber);
    }

    public String getName(){
        return name;
    }

    public Date getBrithDate(){
        return brithDate;
    }

    private MyAdress getAdress(){
        return adress;
    }

//    public MyAdress getAdressStreet(){
//        MyAdress d;
//        d = adress
//    }
}
