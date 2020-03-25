package com.epam.belousov.repository;

public interface Repository<T, V> {

    /**
     * This template for some realise to get one object on repository
     *
     * @param index - entry index object on repository
     * @return one object
     */
    public V getEntity(int index);

    /**
     * This template for some realise to get all objects on repository
     *
     * @return array of objects
     */
    public V[] getAllEntitys();

    /**
     * This template for some realise to save one object to repository
     *
     * @param entyty - entry one object
     */
    public void setEntity(V entyty);

    /**
     * This template for some realise to save all objects to repository
     *
     * @param entytys - entry array of objects
     */
    public void setAllEntitys(V[] entytys);
}
