package Belousov;

import lombok.Data;

@Data
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Service service = new Service();
        service.service();
    }
}
