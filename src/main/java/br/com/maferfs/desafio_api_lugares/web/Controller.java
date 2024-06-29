package br.com.maferfs.desafio_api_lugares.web;

import br.com.maferfs.desafio_api_lugares.api.PlaceRequest;
import br.com.maferfs.desafio_api_lugares.api.PlaceResponse;
import br.com.maferfs.desafio_api_lugares.domain.Place;
import br.com.maferfs.desafio_api_lugares.domain.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class Controller {
    private PlaceService placeService;

    public Controller(PlaceService placeService){
        this.placeService = placeService;
    }
    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create (@RequestBody PlaceRequest request){
        var placeResponse = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }

    @GetMapping
    public ResponseEntity<Flux<PlaceResponse>> lits(){
        var list = placeService.list().map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Mono<PlaceResponse>> listById(@PathVariable String name){
        var specificPlace = placeService.listByName(name).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.OK).body(specificPlace);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String name){
        var deletedPlace = placeService.delete(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedPlace);
    }

}
