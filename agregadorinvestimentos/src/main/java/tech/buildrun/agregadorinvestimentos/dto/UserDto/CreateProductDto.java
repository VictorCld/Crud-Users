package tech.buildrun.agregadorinvestimentos.dto.UserDto;

import java.util.UUID;

public record CreateProductDto(String name, String type, Double price, UUID userId) {
}
