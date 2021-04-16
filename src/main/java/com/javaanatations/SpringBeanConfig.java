package com.javaanatations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    public City getCity(){
      City city =new City();
      city.setNm("Istanbul");
      city.setPlateNumber(34);
      return city;
    }

    @Bean
    public Adress getAdress(){
        Adress adress = new Adress();
        adress.setCity(getCity());
        adress.setNm("yunus");
        return adress;
    }
}
