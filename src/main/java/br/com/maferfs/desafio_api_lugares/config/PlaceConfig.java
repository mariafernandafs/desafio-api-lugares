package br.com.maferfs.desafio_api_lugares.config;

import br.com.maferfs.desafio_api_lugares.domain.PlaceRepository;
import br.com.maferfs.desafio_api_lugares.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepository placeRepository){

        return new PlaceService(placeRepository);
    }

}
