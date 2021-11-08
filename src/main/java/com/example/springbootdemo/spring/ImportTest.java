package com.example.springbootdemo.spring;

import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportTest implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if(i==5){
                return;
            }
            System.out.println(i);
        }
    }
}
