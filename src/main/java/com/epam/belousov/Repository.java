package com.epam.belousov;

public  interface Repository<T,V> {
    public V getEntity(int index);
    public V[] getAllEntitys();
    public void setEntity(V entyty);
    public void setAllEntitys(V[] entytys);
}
