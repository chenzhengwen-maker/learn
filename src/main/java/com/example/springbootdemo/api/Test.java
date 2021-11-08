package com.example.springbootdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
@Component
public class Test {
    @Autowired
    ApplicationContext applicationContext;
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition =
                BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanFactory.registerBeanDefinition("user", beanDefinition);
        System.out.println(beanFactory.getBean("user"));
        Test test = new Test();
        Resource resources = test.applicationContext.getResource("classpath:application.properties");
        resources.getFilename();
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();


    }
}
