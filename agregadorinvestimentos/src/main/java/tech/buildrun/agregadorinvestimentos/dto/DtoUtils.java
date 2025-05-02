package tech.buildrun.agregadorinvestimentos.dto;

import tech.buildrun.agregadorinvestimentos.dto.UserDto.UserDto;
import tech.buildrun.agregadorinvestimentos.entity.User;

import java.util.List;
import java.util.function.Function;

public class DtoUtils {

    public static UserDto userModelToDto(User user){
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCreationTimestamp(),
                user.getUpdateTimestamp()

        );
    }

   public static List<UserDto> convertModelList(List<User> userList, Function<User, UserDto> converter){
       if (userList == null) return List.of();
       return userList.stream().map(converter).toList();
   }


}
