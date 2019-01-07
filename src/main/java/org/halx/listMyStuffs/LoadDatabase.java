package org.halx.listMyStuffs;

import lombok.extern.slf4j.Slf4j;
import org.halx.listMyStuffs.model.Stuff;
import org.halx.listMyStuffs.repository.StuffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(StuffRepository stuffRepository){
        return args -> {
//            log.info("Preloading "+ stuffRepository.save(new Stuff("ecran PC", "Ecran recent 24pouces", 2, 200.50D)));
//            log.info("Preloading "+ stuffRepository.save(new Stuff("ecran PC", "Ecran vieux 17pouces inclinable", 150, 100D)));
        };
    }
}
