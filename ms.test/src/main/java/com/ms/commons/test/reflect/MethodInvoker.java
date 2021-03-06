/*
 * Copyright 2017-2025 msun.com All right reserved. This software is the confidential and proprietary information of
 * msun.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with msun.com.
 */
package com.ms.commons.test.reflect;

/**
 * @author zxc Apr 13, 2013 11:29:19 PM
 */
public class MethodInvoker {

    public static ClassHolder clazz(Class<?> clazz) {
        return new ClassHolder(clazz);
    }

    public static ObjectHolder object(Object object) {
        return new ObjectHolder(object);
    }
}
