package com.springanatations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigOil {
    @Bean(name ="oil")
    public Oil depo(){
        return new Oil();
    }

}
