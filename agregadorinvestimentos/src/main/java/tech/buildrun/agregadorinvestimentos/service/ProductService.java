package tech.buildrun.agregadorinvestimentos.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import tech.buildrun.agregadorinvestimentos.dto.DtoUtils;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.CreateProductDto;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.ProductDto;
import tech.buildrun.agregadorinvestimentos.entity.Product;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.ProductRepository;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;
import tech.buildrun.agregadorinvestimentos.service.exception.UserNotFound;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public ProductDto createProduct(CreateProductDto createProductDto) {
        User user = userRepository.findById(createProductDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Product product = new Product();
        product.setName(createProductDto.name());
        product.setType(createProductDto.type());
        product.setPrice(createProductDto.price());
        product.setUser(user);

        Product savedProduct = productRepository.save(product);

        return DtoUtils.productModelToDto(savedProduct);
    }

    public List<ProductDto> getAllProducts(){
        return DtoUtils.convertModelList(productRepository.findAll(), DtoUtils::productModelToDto);
    }

    public List<ProductDto> getProductsByUser(UUID userId){
        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);

        return DtoUtils.convertModelList(user.getProducts(), DtoUtils::productModelToDto);
    }
}
