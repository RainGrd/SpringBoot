package com.bdqn.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 20:13
 * FileName: MyImportSelector
 * Description:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        try {
            Class<?> clazz = Class.forName("com.bdqn.bean.Mouse");
            if (clazz != null) {
                return new String[]{"com.bdqn.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//            e.printStackTrace();
            return new String[0];
        }
        return null;
    }
}
