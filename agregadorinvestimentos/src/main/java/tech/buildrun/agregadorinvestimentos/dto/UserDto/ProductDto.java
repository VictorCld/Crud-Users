package tech.buildrun.agregadorinvestimentos.dto.UserDto;

import java.util.UUID;

public record ProductDto(
    UUID productId,
    String name,
    String type,
    Double price,
    UUID userId
) {
}
