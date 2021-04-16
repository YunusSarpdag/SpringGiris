package com.springanatations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfigCar {
    @Bean(name ="car", initMethod = "init" , destroyMethod = "destroy")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Car car(){
        Oil oil = new Oil();
        return new Car(oil);
    }

    // Call all bean start
    @Bean
    public InitAppStart start(){
        return new InitAppStart();
    }
}
