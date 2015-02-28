package com.xincao.todo.service;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 动态注册bean（不能用于Flow层中，包含Flow属性的情况）
 * 
 * @author caoxin
 */
@Service
public class DynamicRegistrationBeanService implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(DynamicRegistrationBeanService.class);
    private ApplicationContext ac;

    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ac = ac;
    }

    /**
     *
     * @param beanName
     * @param clazz
     */
    public void registerBean(String beanName, Class clazz) {
        if (ac.containsBean(beanName)) {
            logger.error("Already exists beanName={}", beanName);
            return;
        }
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
                String name = descriptor.getName();
                if (ac.containsBean(name)) {
                    beanDefinitionBuilder.addPropertyValue(name, ac.getBean(name));
                }
            }
        } catch (IntrospectionException e) {
            logger.error(e.getMessage());
        }
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ac;
        BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
        beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
    }
}