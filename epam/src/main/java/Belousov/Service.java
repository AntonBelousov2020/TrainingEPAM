package Belousov;


import java.util.LinkedList;

public class Service implements Repository<Human, HumanDto>{
    private static int length = 3;//Размер массива HumanDto
    private LinkedList<Human> list = new LinkedList<Human>();
    public void service() throws ClassNotFoundException, IllegalAccessException{
        Converter converter = new Converter();
        HumanDto[] humansDto = new HumanDto[length];

        for (int i = 0; i < length; i ++){
            humansDto[i] = this.createRandomHumanDto(i);
        }

        Service service = new Service();
        //Добавление одной сущности
        service.setEntyty(humansDto[0]);
        //Добавление всех сущностей
        service.setAllEntyty(humansDto);
        //Получение одной сущности
        service.getEntyty(2);
        //Получение всех сущностей
        service.getAllEntyty();
    }

    public HumanDto getEntyty(int index) {
        System.out.println("Получение одной сущности");
        Converter converter = new Converter();
        HumanDto humanDto;
        Human human = list.get(index);
        humanDto = converter.convertToDto(human);
        System.out.println(humanDto.toString());
        return humanDto;
    }

    public HumanDto[] getAllEntyty() {
        System.out.println("Получение всех сущностей");
        Converter converter = new Converter();
        Human[] humans = new Human[list.size()];
        for (int i = 0; i < list.size(); i++){
            humans[i] = list.get(i);
        }
        HumanDto[] humanDto = new HumanDto[list.size()];
        for (int i = 0; i < list.size(); i++){
            humanDto[i] = converter.convertToDto(humans[i]);
            System.out.println(humanDto[i].toString());
        }
        return humanDto;
    }

    public void setEntyty(HumanDto entyty) {//Сохранение одной
        Converter converter = new Converter();
        Human human = converter.convertToHuman(entyty);
        System.out.println("Одна сущность сохранена");
        System.out.println(human.toString());
        list.add(human);
    }

    public void setAllEntyty(HumanDto[] entytys) {//Сохранение всех DTO в entyty
        Converter converter = new Converter();
        Human[] humans = new Human[entytys.length];
        System.out.println("Все сущности сохранены");
        for (int i = 0; i < entytys.length; i ++){
            humans[i] = converter.convertToHuman(entytys[i]);
            list.add(humans[i]);
            System.out.println(humans[i].toString());
        }
    }


    public HumanDto createRandomHumanDto(int index){//Генерация сущностей
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
