package belousov;

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
        this.id = id;
        this.name = name;
        this.brithDate = new Date(year, mounth, date);
        this.adress = new Human.MyAdress(street, houseNumber, floorNumber, flatNumber);
    }


    @Data
    @NoArgsConstructor
    protected static class DtoMyAdress {
        private String street;
        private int houseNumber, floorNumber, flatNumber;


        protected DtoMyAdress(String street, int houseNumber, int floorNumber, int flatNumber){
            this.street = street;
            this.houseNumber = houseNumber;
            this.floorNumber = floorNumber;
            this.flatNumber = flatNumber;
        }
    }


    @Override
    public String toString(){
        String s;
        s = String.format("Имя %s, Дата рождения %s, Улица %s, Номер дома %d, Номер этажа %d, Номер квартиры %d",name, brithDate.toString(), adress.getStreet(), adress.getHouseNumber(), adress.getFloorNumber(), adress.getFlatNumber());
        return s;
    }
}
