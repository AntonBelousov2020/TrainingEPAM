package com.epam.belousov;

import com.epam.belousov.pojo.Cat;
import com.epam.belousov.pojo.Human;
import com.epam.belousov.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Service<Human> service = new Service<>();
        List<Human> humanList = service.getExemplarObject(Human.class);
        for (Human human : humanList) {
            log.error(human.getName() + "\t" + human.getAge());
        }

        Service<Cat> service1 = new Service<>();
        List<Cat> catList = service1.getExemplarObject(Cat.class);
        for (Cat cat : catList) {
            log.info(cat.getName() + "\t" + cat.getColouration() + "\t" + cat.getAge());
        }
    }
}
