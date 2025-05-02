package tech.buildrun.agregadorinvestimentos.dto.UserDto;

import java.time.Instant;
import java.util.UUID;

public record UserDto(
        UUID userId,
        String username,
        String email,
        String password,
        Instant creationTimestamp,
        Instant updateTimestamp

        ) {
}
