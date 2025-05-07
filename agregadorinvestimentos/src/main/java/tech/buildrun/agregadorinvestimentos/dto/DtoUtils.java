package tech.buildrun.agregadorinvestimentos.dto;

import tech.buildrun.agregadorinvestimentos.dto.UserDto.ProductDto;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.UserDto;
import tech.buildrun.agregadorinvestimentos.entity.Product;
import tech.buildrun.agregadorinvestimentos.entity.User;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

   public static <T, R> List<R> convertModelList(List<T> modelList, Function<T, R> converter) {
        if (modelList == null || modelList.isEmpty()) return List.of();
        return modelList.stream().map(converter).collect(Collectors.toList());
    }

   public static ProductDto productModelToDto(Product product){
    return new ProductDto(
            product.getProductId(),
            product.getName(),
            product.getType(),
            product.getPrice(),
            product.getUser().getUserId());
   }

   

}
