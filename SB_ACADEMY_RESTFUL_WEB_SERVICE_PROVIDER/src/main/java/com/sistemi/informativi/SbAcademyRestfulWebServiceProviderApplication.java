package com.sistemi.informativi;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//L'annotation EnableCaching abilita la cache di secondo livello di Hibernate
@EnableCaching
public class SbAcademyRestfulWebServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbAcademyRestfulWebServiceProviderApplication.class, args);
    }

    @Bean
    Config hazelCastConfig() {
        return new Config().setInstanceName("hazelcast-interface")
                .addMapConfig(new MapConfig().setName("academies").setTimeToLiveSeconds(20));
    }
}
