package br.com.maferfs.desafio_api_lugares.domain;

import br.com.maferfs.desafio_api_lugares.api.PlaceRequest;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {
    Mono<Place> findByName(String name);

    Mono<Void> deleteByName(String name);
}
