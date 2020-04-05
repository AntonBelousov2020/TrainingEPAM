package com.epam.belousov.task2;

import java.util.List;

/**
 * This pojo class describe some sausage
 */
public class Sausage {
    private String type;
    private int weight;
    private long cost;

    Sausage() {

    }

    Sausage(String type, int weight, long cost) {
        this.type = type;
        this.weight = weight;
        this.cost = cost;
    }

    Sausage(List<String> sausageList) {
        this(sausageList.get(0).replace("'", ""),
                Integer.parseInt(sausageList.get(1)),
                Long.parseLong(sausageList.get(2)));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Sausage{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                "}\n";
    }
}
