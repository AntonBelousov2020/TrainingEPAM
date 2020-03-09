package Belousov;

import java.util.Comparator;
import java.util.Map;

public class CompareToValue<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<Map.Entry<K,V>> {

    @Override
    public int compare(Map.Entry<K, V> kvEntry, Map.Entry<K, V> t1) {
        return kvEntry.getValue().compareTo(t1.getValue());
    }
}
