package Belousov;

import lombok.Data;

@Data
public class Main {
    public static void main(String[] args) throws ServiceExeption, ConverterExeption {
        Service service = new Service();
        service.service();
    }
}
