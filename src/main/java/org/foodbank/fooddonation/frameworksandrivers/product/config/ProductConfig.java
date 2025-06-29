package org.foodbank.fooddonation.frameworksandrivers.product.config;

import org.foodbank.fooddonation.application.usecase.product.impl.CreateProductUseCaseImpl;
import org.foodbank.fooddonation.application.usecase.product.impl.GetProductUseCaseImpl;
import org.foodbank.fooddonation.frameworksandrivers.product.repository.ProductRepository;
import org.foodbank.fooddonation.interfaceadapters.product.controller.CreateProductUseCase;
import org.foodbank.fooddonation.interfaceadapters.product.controller.GetProductUseCase;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.CreateGatewayProduct;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.GetGatewayProduct;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.impl.CreateGatewayProductImpl;
import org.foodbank.fooddonation.interfaceadapters.product.gateway.impl.GetGatewayProductImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

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


    @Bean
    public CreateProductUseCase createProductUseCase(CreateGatewayProduct createGatewayProduct){
        return new CreateProductUseCaseImpl(createGatewayProduct);
    }

    @Bean
    public CreateGatewayProduct createGatewayProduct(ProductRepository repository){
        return new CreateGatewayProductImpl(repository);
    }

    @Bean
    public GetProductUseCase getProductUseCase(GetGatewayProduct gatewayProduct){
        return new GetProductUseCaseImpl(gatewayProduct);
    }

    @Bean
    public GetGatewayProduct getGatewayProduct(ProductRepository repository){
        return new GetGatewayProductImpl(repository);
    }
}
