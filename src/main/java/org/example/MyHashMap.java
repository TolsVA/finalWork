package org.example;

import java.util.HashMap;
import java.util.Iterator;

public class MyHashMap<K,V> extends HashMap {
    @Override
    public String toString() {
        Iterator<Entry<K,V>> i = entrySet().iterator();
        if (! i.hasNext())
            return "{}";

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (;;) {
            Entry<K,V> e = i.next();
            V value = e.getValue();
            sb.append("\t");
            sb.append(value == this ? "(this Map)" : value);
            if (! i.hasNext())
                return sb.append("\n}").toString();
            sb.append(',').append("\n");
        }
    }
}
