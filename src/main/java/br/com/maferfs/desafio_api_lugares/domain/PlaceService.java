package br.com.maferfs.desafio_api_lugares.domain;

import br.com.maferfs.desafio_api_lugares.api.PlaceRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> create(PlaceRequest placeRequest){
        var place = new Place(null, placeRequest.name(), placeRequest.slug(), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        return placeRepository.save(place);
    }
    public Flux<Place> list(){
        return placeRepository.findAll();
    }
    public Mono<Place> listByName(String name){
        return placeRepository.findByName(name);
    }
    public Mono<Void> delete(String name){
        return placeRepository.deleteByName(name);
    }

}
