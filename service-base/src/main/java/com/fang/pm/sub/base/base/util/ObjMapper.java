package com.fang.pm.sub.base.base.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class ObjMapper {

    public static HashMap<String, Object> objToMap(Object obj, String... require) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();    // 获取f对象对应类中的所有属性域
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            try {
                boolean accessFlag = fields[i].isAccessible();    // 获取原来的访问控制权限
                fields[i].setAccessible(true);                    // 修改访问控制权限
                Object o = fields[i].get(obj);                    // 获取在对象f中属性fields[i]对应的对象中的变量
                if (o != null) {
                    if (require.length > 0) {
                        if (Arrays.asList(require).contains(varName)) {
                            map.put(varName, o);
                        }
                    } else
                        map.put(varName, o);
                }
                fields[i].setAccessible(accessFlag);            // 恢复访问控制权限
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

}
