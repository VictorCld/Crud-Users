package tech.buildrun.agregadorinvestimentos.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends NotFoundException{
    public UserNotFound() {
        super("Usuario não encontrado");
    }
}
