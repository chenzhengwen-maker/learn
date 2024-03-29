package com.example.springbootdemo.springutil;

import com.example.springbootdemo.api.A;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Classname AnnotationMetaDataDemo
 * @Description TODO
 * @Author Jack
 * Date 2020/12/30 20:44
 * Version 1.0
 */
@Component
public class AnnotationMetaDataDemo implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void metaData() {
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
        try {
            MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(A.class.getName());
            System.out.println(metadataReader);

            AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

            AnnotationAttributes comArr = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(Component.class.getName(),false));
            AnnotationAttributes scopeArr = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(Scope.class.getName(),false));

            MergedAnnotations annotations = metadataReader.getAnnotationMetadata().getAnnotations();
            System.out.println(annotations);
            MergedAnnotation<Component> componentMergedAnnotation = annotations.get(Component.class);
            System.out.println(componentMergedAnnotation);
            AnnotationAttributes annotationAttributes1 = componentMergedAnnotation.asAnnotationAttributes(MergedAnnotation.Adapt.ANNOTATION_TO_MAP);
            System.out.println(annotationAttributes1);

            MergedAnnotation<Scope> scopeMergedAnnotation = annotations.get(Scope.class);
            System.out.println(scopeMergedAnnotation);
            AnnotationAttributes scopeAa = scopeMergedAnnotation.asAnnotationAttributes(MergedAnnotation.Adapt.ANNOTATION_TO_MAP);
            System.out.println(scopeAa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
