package com.epam.belousov;

import com.epam.belousov.task1.MyStream;
import com.epam.belousov.task2.StreamSausage;

public class Main {
    public static void main(String[] args) {
        MyStream myStream = new MyStream();
        myStream.streamWork();
        myStream.findEndOfTheWorld();

        StreamSausage streamSausage = new StreamSausage();
        streamSausage.streamSausage("File.txt");
    }
}
