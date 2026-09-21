package org.j2os;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
    private SpringContext(){}
    private static final ApplicationContext CONTEXT =
            new ClassPathXmlApplicationContext("spring.xml");

    public static Object getBean(String beanId) {
        return CONTEXT.getBean(beanId);
    }
}
