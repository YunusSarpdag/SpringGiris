package com.springstart;

import com.componenet.TestComponent;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class AppStart {

    private static final Logger LOGGER = Logger.getLogger(AppStart.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        LOGGER.debug("debug log");
        LOGGER.error("test error");
        BeanFactory beanFactory = new XmlBeanFactory
                (new FileSystemResource("spring.xml")) ;

        //Araba araba = new Araba(); IOC
        Car car = (Car) beanFactory.getBean("car");
        car.hareketeGec();

        Resource resource = new FileSystemResource("spring.xml");
        XmlBeanFactory xmlBeanFactory1 = new XmlBeanFactory(resource);
        Car car2 = xmlBeanFactory1.getBean("car" ,Car.class);
        car2.hareketeGec();

        /*
        spring.xml in src folder
        ClassPathResource classPathResource = new ClassPathResource("spring.xml");
        BeanFactory beanFactory1 = new XmlBeanFactory(classPathResource);
        Car car3 = (Car) beanFactory1.getBean("car");
         */

        /*
        spring.xml in src folder
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        BeanFactory beanFactory2 = context;
        Car car4 = (Car) beanFactory2.getBean("car");
        car4.hareketeGec();
         */

        Audi audi = (Audi) xmlBeanFactory1.getBean("audi");
        audi.hareketeGec();

        Car1 car1 = (Car1) xmlBeanFactory1.getBean("car1"); // parameter cons dependency injection

        TestComponent testComponent = xmlBeanFactory1.getBean("testComponentBean" , TestComponent.class);
        testComponent.setNm("yunus");
        System.out.println("Componenet : " + testComponent.getNm());
    }
}
