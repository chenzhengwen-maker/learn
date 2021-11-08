package com.example.springbootdemo.springutil;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Classname MetaDataReaderTest
 * @Description TODO
 * @Author Jack
 * Date 2020/12/14 16:34
 * Version 1.0
 */
public class MetaDataReaderTest {
    public void test1() {
        FileSystemResource fileSystemResource = new FileSystemResource("E:\\idea\\xiangxueedu-vip-3\\spring-source\\target\\classes\\com\\enjoy\\jack\\bean\\Jack.class");
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();
        try {
            MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(fileSystemResource);
            System.out.println(metadataReader);
            Set<MethodMetadata> annotatedMethods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(Component.class.getName());
            for (MethodMetadata annotatedMethod : annotatedMethods) {
                System.out.println(annotatedMethod.getMethodName() + "--" + annotatedMethod.getReturnTypeName());
            }
            Map<String, Object> annotationAttributes = metadataReader.getAnnotationMetadata().getAnnotationAttributes(Component.class.getName(), false);
            System.out.println(annotationAttributes);

            MergedAnnotations annotations = metadataReader.getAnnotationMetadata().getAnnotations();
            System.out.println(annotations);
            MergedAnnotation<Component> componentMergedAnnotation = annotations.get(Component.class);
            System.out.println(componentMergedAnnotation);
            AnnotationAttributes annotationAttributes1 = componentMergedAnnotation.asAnnotationAttributes(MergedAnnotation.Adapt.ANNOTATION_TO_MAP);
            System.out.println(annotationAttributes1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanBean.class);
        com.enjoy.jack.tools.metaDataReader.AnnotationMetaDataDemo rl = applicationContext.getBean(com.enjoy.jack.tools.metaDataReader.AnnotationMetaDataDemo.class);
        rl.metaData();
    }*/
}
