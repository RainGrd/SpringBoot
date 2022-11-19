package com.bdqn.bean;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 16:42
 * FileName: MyImportSelector
 * Description:
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        System.out.println(metadata.getClassName());
        boolean annotation = metadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes("org.springframework.context.annotation.ComponentScan");
        System.out.println("annotationAttributes = " + annotationAttributes);
        System.out.println("annotation = " + annotation);
        return new String[]{"com.bdqn.bean.Dog"};
    }
}
