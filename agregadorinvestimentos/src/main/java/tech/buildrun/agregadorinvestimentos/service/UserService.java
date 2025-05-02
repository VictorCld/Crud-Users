package tech.buildrun.agregadorinvestimentos.service;

import org.springframework.stereotype.Service;
import tech.buildrun.agregadorinvestimentos.dto.DtoUtils;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.UserDto;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.CreateUserDto;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;
import tech.buildrun.agregadorinvestimentos.service.exception.UserNotFound;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto createUser(CreateUserDto createUserDto) {

       User newUser = new User(
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password());


        User userSaved = userRepository.save(newUser);

        return new UserDto(
                userSaved.getUserId(),
                userSaved.getUsername(),
                userSaved.getEmail(),
                userSaved.getPassword(),
                userSaved.getCreationTimestamp(),
                userSaved.getUpdateTimestamp()

        );
    }

    public List<UserDto> getAll(){
        List<User> users = userRepository.findAll();
        return DtoUtils.convertModelList(users, DtoUtils::userModelToDto );
    }

    public UserDto findById(UUID userId){
        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);
        return DtoUtils.userModelToDto(user);
    }

    public void deleteById(UUID userId){
        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);

        userRepository.deleteById(userId);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public UserDto updateUser(UUID userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);

        if (userDto.username() != null && !userDto.username().isBlank()) {
            user.setUsername(userDto.username());
        }
        if (userDto.email() != null && !userDto.email().isBlank()) {
            user.setEmail(userDto.email());
        }
        if (userDto.password() != null && !userDto.password().isBlank()) {
            user.setPassword(userDto.password());
        }

        User updatedUser = userRepository.save(user);
        return DtoUtils.userModelToDto(updatedUser);
    }

}
