package org.j2os;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
    private static final ApplicationContext CONTEXT =
            new ClassPathXmlApplicationContext("spring.xml");

    private SpringContext() {}

    public static Object getBean(String beanId){
        return CONTEXT.getBean(beanId);
    }

}
