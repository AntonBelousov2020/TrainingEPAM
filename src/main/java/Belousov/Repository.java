package Belousov;

public interface Repository<V> {

    public V getEntity(int index);
    public V[] getAllEntity();
    public void setEntity(V entyty);
    public void setAllEntity(V[] entytys);
}
