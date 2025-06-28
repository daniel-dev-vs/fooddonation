package org.foodbank.fooddonation.frameworksandrivers.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

@Configuration
public class FoodDonationConfig {

//    @Bean
//    BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry){
//        return beanFactory -> {
//            genericApplicationContext(
//                    (BeanDefinitionRegistry) ((AnnotationConfigServletWebApplicationContext)beanRegistry)
//                            .getBeanFactory() );
//        };
//    }
//
//    void genericApplicationContext(BeanDefinitionRegistry beanRegistry){
//        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
//        beanDefinitionScanner.addExcludeFilter(removeModelEntitiesAndUsesCasesFilter());
//        beanDefinitionScanner.scan("org.foodbank.fooddonation");
//
//    }
//
//    private TypeFilter removeModelEntitiesAndUsesCasesFilter() {
//        return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
//                .getClassName()
//                .endsWith("Model");
//    }

}
