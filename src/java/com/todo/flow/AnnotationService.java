package com.todo.flow;

import com.todo.service.DynamicRegistrationBeanService;
import eu.infomas.annotation.AnnotationDetector;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javolution.util.FastMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class AnnotationService {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationService.class);
    private static final Pattern pattern = Pattern.compile("^\\s*([a-zA-Z0-9_]+)\\(([0-9,:\\s-]*)\\)\\s*$");
    private Map<String, Object> flows = new FastMap<String, Object>().shared();
    @Autowired
    private DynamicRegistrationBeanService drbs;

    public AnnotationService() {
        this.scanForFlow();
    }

    private void scanForFlow() {
        this.flows = scanForAnnotion(new Class[]{Flow.class});
    }

    private Map<String, Object> scanForAnnotion(final Class[] annotations) {
        final Map<String, Object> annotationMap = new HashMap<String, Object>();
        AnnotationDetector.TypeReporter reporter = new AnnotationDetector.TypeReporter() {

            @Override
            @SuppressWarnings("unchecked")
            public Class<? extends Annotation>[] annotations() {
                return annotations;
            }

            @Override
            public void reportTypeAnnotation(Class<? extends Annotation> annotationClass, String className) {
                try {
                    Class clazz = Class.forName(className);
                    Flow base = (Flow) clazz.getAnnotation(annotationClass);
                    String value = base.value();
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

    public static void main(String[] args) {
        AnnotationService as = new AnnotationService();
        logger.info(as.getFlows().toString());
    }
}