package com.fang.pm.sub.base.base.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class MapGenerator<K, V> extends HashMap<K, V> {

    public MapGenerator addItem(K k, V v) {
        put(k, v);
        return this;
    }




}
