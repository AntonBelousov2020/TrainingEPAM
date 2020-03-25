package com.epam.belousov.comparators;

import java.util.Comparator;
import java.util.Map;

public class CompareToKey<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>> {

    /**
     * Implementation of interface Comparator
     *
     * @param kvEntry - the first entry to be compared
     * @param t1      - the second entry to be compared
     * @return a negative integer, zero, a positive integer as the first argument is less than, equal to,
     * or greater than the second
     */
    @Override
    public int compare(Map.Entry<K, V> kvEntry, Map.Entry<K, V> t1) {
        return kvEntry.getKey().compareTo(t1.getKey());
    }
}
