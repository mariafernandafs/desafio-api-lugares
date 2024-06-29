package br.com.maferfs.desafio_api_lugares.web;

import br.com.maferfs.desafio_api_lugares.api.PlaceResponse;
import br.com.maferfs.desafio_api_lugares.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
