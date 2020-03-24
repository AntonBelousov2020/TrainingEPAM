package com.epam.belousov;


import java.util.LinkedList;

public class Service implements Repository<Human, HumanDto>{

    private static final int LENGTH_ARR_DTO = 3;//Размер массива HumanDto
    private LinkedList<Human> humanList = new LinkedList<Human>();

    public void service() throws ClassNotFoundException, IllegalAccessException{


        Converter converter = new Converter();
        HumanDto[] humansDto = new HumanDto[LENGTH_ARR_DTO];

        for (int i = 0; i < LENGTH_ARR_DTO; i ++){
            humansDto[i] = this.createRandomHumanDto(i);
        }

        Service service = new Service();
        service.setEntity(humansDto[0]);
        service.setAllEntitys(humansDto);

        service.getEntity(2);
        service.getAllEntitys();
    }

    public HumanDto getEntity(int index) {
        System.out.println("Geting one entity");
        Converter converter = new Converter();
        HumanDto humanDto;
        Human human = humanList.get(index);
        humanDto = converter.convertToDto(human);
        System.out.println(humanDto.toString());
        return humanDto;
    }

    public HumanDto[] getAllEntitys() {
        System.out.println("Getting all entitys");
        Converter converter = new Converter();
        Human[] humans = new Human[humanList.size()];
        for (int i = 0; i < humanList.size(); i++){
            humans[i] = humanList.get(i);
        }
        HumanDto[] humansDto = new HumanDto[humanList.size()];
        for (int i = 0; i < humanList.size(); i++){
            humansDto[i] = converter.convertToDto(humans[i]);
            System.out.println(humansDto[i].toString());
        }
        return humansDto;
    }

    public void setEntity(HumanDto humanDto) {//Сохранение одной
        Converter converter = new Converter();
        Human human = converter.convertToHuman(humanDto);
        System.out.println("One entity saved");
        System.out.println(human.toString());
        humanList.add(human);
    }

    public void setAllEntitys(HumanDto[] humansDto) {//Сохранение всех DTO в entyty
        Converter converter = new Converter();
        Human[] humans = new Human[humansDto.length];
        System.out.println("All entity saved");
        for (int i = 0; i < humansDto.length; i ++){
            humans[i] = converter.convertToHuman(humansDto[i]);
            humanList.add(humans[i]);
            System.out.println(humans[i].toString());
        }
    }


    private HumanDto createRandomHumanDto(int index){//Генерация сущностей
        Human human = new Human();
        String[] nameRandom = {"Алексей","Иван","Михаил","Антон","Раимль"};
        int yearRandom = 1968 + (int) (Math.random()*52);
        int mounthRandom = 1 + (int) (Math.random()*11);
        int dateRandom = 1 + (int) (Math.random()*28);
        String streetRandom[] = {"Гая", "Юбилейная", "Свердлова", "Тополиная", "Советская"};
        int houseNumbeerRandom = 1 + (int) (Math.random()*50);
        int floorNumberRandom = 1 + (int) (Math.random()*15);
        int flatNumberRandom = 1 + (int) (Math.random()*227);
        HumanDto humanDto = new HumanDto(index,nameRandom[(int)(Math.random()*nameRandom.length)], yearRandom, mounthRandom, dateRandom,
                streetRandom[(int) (Math.random()*streetRandom.length)], houseNumbeerRandom, floorNumberRandom, flatNumberRandom);
        return humanDto;
    }

}
