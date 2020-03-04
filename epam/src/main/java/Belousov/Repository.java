package Belousov;

public  interface Repository<T,V> {
    public V getEntyty(int index);
    public V[] getAllEntyty();
    public void setEntyty(V entyty);
    public void setAllEntyty(V[] entytys);
}
