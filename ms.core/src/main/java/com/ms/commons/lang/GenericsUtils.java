/*
 * Copyright 2017-2025 msun.com All right reserved. This software is the confidential and proprietary information of
 * msun.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with msun.com.
 */
package com.ms.commons.lang;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 * 
 * @author zxc Apr 12, 2013 2:34:08 PM
 */
@SuppressWarnings("rawtypes")
public class GenericsUtils {

    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    public static Class getSuperInterfaceGenriceType(Class clazz) {
        return getSuperInterfaceGenriceType(clazz, 0, 0);
    }

    /**
     * 通过反射获取父类的实际参数类型。
     * 
     * @param clazz 需要反射的类
     * @param index 泛型参数索引，从0开始
     */
    public static Class getSuperClassGenricType(Class clazz, int index) {
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        if ((genericSuperclass instanceof ParameterizedType) == false) {
            return null;
        }
        ParameterizedType paramterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramterizedType.getActualTypeArguments();
        if (actualTypeArguments.length < (index - 1) || actualTypeArguments.length == 0) {
            return null;
        }
        return (Class) actualTypeArguments[0];
    }

    /**
     * 通过反射获取父接口的实际参数类型。
     * 
     * @param clazz 需要反射的类
     * @param interfaceIndex 接口索引，从0开始
     * @param typeIndex 泛型参数索引，从0开始。
     */
    public static Class getSuperInterfaceGenriceType(Class clazz, int interfaceIndex, int typeIndex) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        Type type = genericInterfaces[interfaceIndex];
        if ((type instanceof ParameterizedType) == false) {
            return Object.class;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        return (Class) actualTypeArguments[typeIndex];
    }

    public static interface Super<T> {

    }

    public static class MyClass<T> implements Super<String> {

    }

    public static class MyClass2 extends MyClass<Integer> {

    }

    public static class MyInterface implements Super<String> {

    }

    public static void main(String[] args) {
        System.out.println(getSuperClassGenricType(MyClass2.class, 0));
        // class java.lang.Integer
        System.out.println(getSuperInterfaceGenriceType(MyInterface.class, 0, 0));
        // java.lang.String
    }
}
