package com.epam.belousov;

import com.epam.belousov.generativepatterns.factorymethod.FactoryMethod;
import com.epam.belousov.generativepatterns.prototype.PrototypeWork;
import com.epam.belousov.structuralpatterns.adapter.AdapterWork;
import com.epam.belousov.structuralpatterns.bridge.BridgeWork;
import com.epam.belousov.structuralpatterns.bridge.Radio;
import com.epam.belousov.structuralpatterns.bridge.Tv;

public class Main {
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        factoryMethod.configure();
        factoryMethod.createPatty();

        PrototypeWork prototypeWork = new PrototypeWork();
        prototypeWork.configure();

        AdapterWork adapterWork = new AdapterWork();
        adapterWork.adapterWork();

        BridgeWork bridgeWork = new BridgeWork();
        bridgeWork.bridgeWork(new Tv());
        bridgeWork.bridgeWork(new Radio());
    }
}
