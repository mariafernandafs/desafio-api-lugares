package br.com.maferfs.desafio_api_lugares;

import br.com.maferfs.desafio_api_lugares.api.PlaceRequest;
import br.com.maferfs.desafio_api_lugares.domain.Place;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioApiLugaresApplicationTests {
	@Autowired
	WebTestClient webTestClient;
	@Test
	void testCreatePlaceSucess() {
		var name = "São Bernardo do Campo";
		var state = "São Paulo";
		var slug = "sao-bernardo-do-campo";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state))
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createdAt").isNotEmpty()
				.jsonPath("updatedAt").isNotEmpty();

	}

	@Test
	void testCreatePlaceError() {
		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest("", ""))
				.exchange()
				.expectStatus().isBadRequest();
	}

}
