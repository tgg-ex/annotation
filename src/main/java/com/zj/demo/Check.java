package com.zj.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {

    public static void chech(Object object) throws NoSuchMethodException {
        if (null == object) {
            return;
        }
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<Field>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        fieldList.forEach(field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                Info annotation = field.getAnnotation(Info.class);
                if (null == annotation) {
                    return;
                }
//                checkMax(value, annotation);
                checkMin(value, annotation);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                //数据解析失败
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static void checkMax(Object value, Info annotation) {
        if (value.toString().length() > annotation.max().length()) {
            throw new RuntimeException(annotation.value());
        }
    }

    public static void checkMin(Object value, Info annotation) {
        if (value.toString().length() < annotation.min().length()) {
            throw new RuntimeException(annotation.value());
        }
    }
}
