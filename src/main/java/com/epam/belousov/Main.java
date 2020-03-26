package com.epam.belousov;

import com.epam.belousov.exeptions.ConverterExeption;
import com.epam.belousov.exeptions.ServiceExeption;
import com.epam.belousov.service.Service;

public class Main {
    public static void main(String[] args) throws ServiceExeption, ConverterExeption {
        Service service = new Service();
        service.service();
    }
}
