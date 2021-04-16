package com.springanatations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {AppConfigOil.class , AppConfigCar.class})
public class AppConfig {
}
