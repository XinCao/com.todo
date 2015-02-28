package com.xincao.todo.service;

import com.xincao.todo.flow.Flow;
import com.xincao.todo.util.MethodRuntimeStats;
import eu.infomas.annotation.AnnotationDetector;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注解扫描
 *
 * @author caoxin
 */
@Service
public class AnnotationScanService extends MethodRuntimeStats {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationScanService.class);
    private static final Pattern pattern = Pattern.compile("^\\s*([a-zA-Z0-9_]+)\\(([0-9,:\\s-]*)\\)\\s*$");
    private Map<String, Object> flows = new ConcurrentHashMap<String, Object>();
    @Autowired
    private DynamicRegistrationBeanService drbs;

    public void initMethod() {
        this.scanForFlow();
    }

    private void scanForFlow() {
        this.flows = scanForFlow(new Class[]{Flow.class});
    }

    private Map<String, Object> scanForFlow(final Class[] annotations) {
        final Map<String, Object> annotationMap = new HashMap<String, Object>();
        AnnotationDetector.TypeReporter reporter = new AnnotationDetector.TypeReporter() {

            @SuppressWarnings("unchecked")
            public Class<? extends Annotation>[] annotations() {
                return annotations;
            }

            public void reportTypeAnnotation(Class annotationClass, String className) {
                try {
                    Class clazz = Class.forName(className);
                    Flow flow = (Flow) clazz.getAnnotation(annotationClass);
                    String value = flow.value();
                    if (value == null || value.isEmpty()) {
                        throw new IllegalArgumentException("类 <" + className + "> 的 Annotation 设置不正确，value 属性必须设置");
                    }
                    annotationMap.put(value, clazz.newInstance());
//                    drbs.registerBean(value, clazz); // 注册为bean
                } catch (ClassNotFoundException ex) {
                    logger.error("没有找到类 <" + className + ">。error=" + ex.getMessage());
                    System.exit(1);
                } catch (InstantiationException ex) {
                    logger.error(ex.getLocalizedMessage());
                } catch (IllegalAccessException ex) {
                    logger.error(ex.getLocalizedMessage());
                }
            }
        };
        try {
            final AnnotationDetector ad = new AnnotationDetector(reporter);
            ad.detect();
            return Collections.unmodifiableMap(annotationMap);
        } catch (IOException ex) {
            logger.error("Faild to scan flows。error={}", ex.getMessage());
            System.exit(1);
        }
        return null;
    }

    public Map<String, Object> getFlows() {
        return flows;
    }

    @Override
    protected void defineBlock(Object... params) {
        this.initMethod();
    }
}