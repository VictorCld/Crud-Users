package tech.buildrun.agregadorinvestimentos.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.CreateUserDto;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.UserDto;
import tech.buildrun.agregadorinvestimentos.service.UserService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "user")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserDto));
    }

    @GetMapping(value = "user")
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }

    @DeleteMapping(value = "user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/users")
    public ResponseEntity<Void> deleteAllUsers(@RequestParam boolean confirm){
        if (!confirm) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        userService.deleteAllUsers();
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userDto));
    }

}
