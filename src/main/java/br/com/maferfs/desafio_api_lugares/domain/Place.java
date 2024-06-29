package br.com.maferfs.desafio_api_lugares.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record Place(
        Long id, String name, String slug, String state,
        @CreatedDate LocalDateTime createdAt, @LastModifiedDate LocalDateTime updatedAt) {
}
