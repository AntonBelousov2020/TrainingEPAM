package Belousov;


import java.util.LinkedList;

public class Service implements Repository<Human, HumanDto>{
    private static int length = 3;//Размер массива HumanDto
    private LinkedList<Human> list = new LinkedList<Human>();
    public void service() throws ClassNotFoundException, IllegalAccessException{
        Converter converter = new Converter();
        HumanDto[] humansDto = new HumanDto[length];
        HumanDto humanDto = new HumanDto();

        for (int i = 0; i < length; i ++){
            humansDto[i] = humanDto.createRandomHumanDto();
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
        humanDto = converter.convert(human);
        System.out.println(humanDto.toStringHD());
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
            humanDto[i] = converter.convert(humans[i]);
            System.out.println(humanDto[i].toStringHD());
        }
        return humanDto;
    }

    public void setEntyty(HumanDto entyty) {
        Converter converter = new Converter();
        Human human = converter.convert(entyty);
        System.out.println("Одна сущность сохранена");
        System.out.println(human.toStringH());
        list.add(human);
    }

    public void setAllEntyty(HumanDto[] entytys) {
        Converter converter = new Converter();
        Human[] humans = new Human[entytys.length];
        System.out.println("Все сущности сохранены");
        for (int i = 0; i < entytys.length; i ++){
            humans[i] = converter.convert(entytys[i]);
            list.add(humans[i]);
            System.out.println(humans[i].toStringH());
        }
    }

}
